package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.IATACarrierCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment's transfer to another airline was manifested.\nConforms to CIMP FSU status 'TRM'.")
public class TransferManifested extends FlightEvent {
    public TransferManifested(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The carrier receiving the transferred consignment.")
    public IATACarrierCode receivingCarrier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport of the transfer.")
    public IATAAirportCode airportOfTransfer;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfTransfer);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
