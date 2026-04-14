package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Flight History indicates latest status, or statuses, in the movement of the nominated consignment.")
@Schema(description = "A Flight History indicates latest status, or statuses, in the movement of the nominated consignment.")
public class FlightHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air way bill number.")
    @Schema(description = "Contains the air way bill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of consignment details.")
    @Schema(description = "Array of consignment details.")
    public List<SplitConsignment> consignments = new ArrayList<>();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    private void writeObject(ObjectOutputStream out)
            throws IOException, ClassNotFoundException {
        out.writeUTF(DefaultObjectMapperBuilder.globalMapper().writeValueAsString(this));
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        String json = stream.readUTF();
        FlightHistory msg = DefaultObjectMapperBuilder.globalMapper().readValue(json, FlightHistory.class);
        this.airWaybillNumber = msg.airWaybillNumber;
        this.consignments = msg.consignments;
        this.otherServiceInformation = msg.otherServiceInformation;
    }

    public List<FlightStatus> convertToStatuses() {
        return consignments.stream().flatMap(c -> c.events.stream().map(evt -> {
                    FlightStatus status = new FlightStatus();
                    status.events.add(evt);
                    status.airWaybillNumber = airWaybillNumber;
                    status.otherCustomsSecurityAndRegulatoryInformation = c.otherCustomsSecurityAndRegulatoryInformation;
                    status.totalNumberOfPieces = c.totalNumberOfPieces;
                    status.quantity = c.quantity;
                    status.originAndDestination = c.originAndDestination;
                    status.otherServiceInformation = Optional.ofNullable(evt.otherServiceInformation).orElse(Optional.empty());
                    return status;
                })
        ).sorted(Comparator.comparing(s -> s.events.get(0).timeOfEvent)
        ).collect(Collectors.toList());
    }
}
