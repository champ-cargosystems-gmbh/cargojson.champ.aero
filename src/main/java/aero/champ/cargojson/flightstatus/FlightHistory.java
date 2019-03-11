package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Flight History indicates latest status, or statuses, in the movement of the nominated consignment.")
public class FlightHistory implements Serializable {

    private static final long serialVersionUID = 1l;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of consignment details.")
    public List<SplitConsignment> consignments = new ArrayList<>();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @JsonDocExample("Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    private void writeObject(ObjectOutputStream out)
            throws IOException, ClassNotFoundException {
        out.writeUTF(DefaultObjectMapperBuilder.globalMapper().writeValueAsString(this));
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        String json = stream.readUTF();
        FlightHistory msg = DefaultObjectMapperBuilder.globalMapper().readValue(json,FlightHistory.class);
        this.airWaybillNumber = msg.airWaybillNumber;
        this.consignments = msg.consignments;
        this.otherServiceInformation = msg.otherServiceInformation;
    }

    public List<FlightStatus> convertToStatuses() {
        return consignments.stream().flatMap(c->{
            return c.events.stream().map(evt->{
                FlightStatus status = new FlightStatus();
                status.events.add(evt);
                status.airWaybillNumber = airWaybillNumber;
                status.otherCustomsSecurityAndRegulatoryInformation = c.otherCustomsSecurityAndRegulatoryInformation;
                status.totalNumberOfPieces = c.totalNumberOfPieces;
                status.quantity = c.quantity;
                status.originAndDestination = c.originAndDestination;
                status.otherServiceInformation = evt.otherServiceInformation;
                return status;
            });
        }).sorted((s1,s2)->
            s1.events.get(0).timeOfEvent.compareTo(s2.events.get(0).timeOfEvent)
        ).collect(Collectors.toList());
    }

}
