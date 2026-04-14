package aero.champ.cargojson.customs;

import aero.champ.cargojson.common.CustomsActionCode;
import aero.champ.cargojson.common.CustomsStatusCode;
import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import aero.champ.cargojson.flightstatus.FlightStatus;
import aero.champ.cargojson.flightstatus.FlightStatusMessage;
import aero.champ.cargojson.flightstatus.events.*;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;
import java.util.Optional;

@JsonClassDescription("Cargo Canonical message containing a Customs Status Notification as payload.")
@Schema(description = "Cargo Canonical message containing a Customs Status Notification as payload.")
@JsonDocHint(toplevel = true)
public class CustomsStatusNotificationMessage extends Message<CustomsStatusNotification> {

    public  FlightStatusMessage convertToFlightStatus() {
        CustomsStatusNotification csnPayload = this.payload;
        FlightStatusMessage msg = new FlightStatusMessage();
        msg.messageHeader = this.messageHeader;
        msg.id = this.id;
        msg.payload = new FlightStatus();
        msg.payload.airWaybillNumber = csnPayload.airWaybillNumber;
        msg.payload.originAndDestination = Optional.of(new OriginAndDestination(csnPayload.airportCodeOfLoading,csnPayload.airportCodeOfUnloading));
        CustomsStatusNotification csn = this.payload;
        if (csn.relation.filter(r->r == Relation.Customs).isPresent()) {
            for (CustomsAction action : csn.customsActions) {
                if (!action.briefStatus.isPresent())
                    continue;
                switch (action.briefStatus.get()) {
                    case Accepted:
                        CustomsCleared customsCleared = new CustomsCleared();
                        msg.payload.events.add(customsCleared);
                        customsCleared.airportOfClearance = csn.airportCodeOfFirstEntryPoint.orElse(csn.airportCodeOfUnloading);
                        copyCommonCustomsAttributes(action, customsCleared);
                        break;
                    case Error:
                        CustomsError error = new CustomsError();
                        msg.payload.events.add(error);
                        error.airportOfError = csn.airportCodeOfFirstEntryPoint.orElse(csn.airportCodeOfUnloading);
                        copyCommonCustomsAttributes(action, error);
                        break;
                    case Hold:
                        CustomsOnHold customsOnHold = new CustomsOnHold();
                        msg.payload.events.add(customsOnHold);
                        customsOnHold.airportOfHold = csn.airportCodeOfFirstEntryPoint.orElse(csn.airportCodeOfUnloading);
                        copyCommonCustomsAttributes(action, customsOnHold);
                        break;
                    case Reported:
                        ReportedToCustoms reported = new ReportedToCustoms();
                        msg.payload.events.add(reported);
                        reported.airportOfReporting = csn.airportCodeOfFirstEntryPoint.orElse(csn.airportCodeOfUnloading);
                        copyCommonCustomsAttributes(action,reported);
                        break;
                }
            }
        }
        return msg;
    }

    private void copyCommonCustomsAttributes(CustomsAction action, CustomsEvent customsEvent) {
        customsEvent.timeOfEvent = action.dateOfNotification;
        customsEvent.numberOfPieces = Optional.ofNullable(action.actionedNumberOfPieces).orElse(BigInteger.ZERO);
        customsEvent.otherServiceInformation = Optional.ofNullable(action.notification);
        customsEvent.customsStatusCode = Optional.ofNullable(action.customsStatusCode).map(CustomsStatusCode::code);
        customsEvent.notification = Optional.ofNullable(action.notification);
        customsEvent.customsActionCode = Optional.ofNullable(action.customsActionCode).map(CustomsActionCode::code);
        customsEvent.customsEntryNumber = Optional.ofNullable(action.customsEntryNumber);
        customsEvent.bondedPremisesIdentification = action.bondedPremisesIdentification;
        customsEvent.nameOfNominatedAgentOrConsignee = action.nameOfNominatedAgentOrConsignee;
        customsEvent.participantCodeOfNominatedAgentOrConsignee = action.participantCodeOfNominatedAgentOrConsignee;
    }


}
