package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import aero.champ.cargojson.flightstatus.events.OtherCustomsSecurityAndRegulatoryInformation;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import aero.champ.cargojson.truckingstatus.TruckingEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Flight Status indicates a status in the movement of the nominated consignment.")
@Schema(description = "A Flight Status indicates a status in the movement of the nominated consignment.")
public class FlightStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    @Schema(description="Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonPropertyDescription("Origin and destination airports of the consignment.")
    @Schema(description="Origin and destination airports of the consignment.")
    public Optional<OriginAndDestination> originAndDestination = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Quantity details of the consignment.")
    @Schema(description="Quantity details of the consignment.")
    public Quantity quantity;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total number of pieces of the consignment.")
    @Schema(description = "Total number of pieces of the consignment.", example = "20")
    public BigInteger totalNumberOfPieces;

    @JsonPropertyDescription("List of flight events related to the flight status. Will often be only one event.")
    @Schema(description="List of flight events related to the flight status. Will often be only one event.")
    public List<FlightEvent> events = new ArrayList<>();

    @JsonPropertyDescription("List of trucking events related to the flight status.")
    @Schema(description="List of trucking events related to the flight status.")
    public List<TruckingEvent> truckingEvents = new ArrayList<>();

    @JsonPropertyDescription("Other customs, security and regulatory information.")
    @Schema(description="Other customs, security and regulatory information.")
    public Optional<OtherCustomsSecurityAndRegulatoryInformation> otherCustomsSecurityAndRegulatoryInformation = Optional.empty();

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
        FlightStatus msg = DefaultObjectMapperBuilder.globalMapper().readValue(json,FlightStatus.class);
        this.airWaybillNumber = msg.airWaybillNumber;
        this.originAndDestination = msg.originAndDestination;
        this.quantity = msg.quantity;
        this.totalNumberOfPieces = msg.totalNumberOfPieces;
        this.events = msg.events;
        this.otherCustomsSecurityAndRegulatoryInformation = msg.otherCustomsSecurityAndRegulatoryInformation;
        this.otherServiceInformation = Optional.ofNullable(msg.otherServiceInformation).orElse(Optional.empty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightStatus)) return false;
        FlightStatus that = (FlightStatus) o;
        return Objects.equals(airWaybillNumber, that.airWaybillNumber) && Objects.equals(originAndDestination, that.originAndDestination) && Objects.equals(quantity, that.quantity) && Objects.equals(totalNumberOfPieces, that.totalNumberOfPieces) && Objects.equals(events, that.events) && Objects.equals(truckingEvents, that.truckingEvents) && Objects.equals(otherCustomsSecurityAndRegulatoryInformation, that.otherCustomsSecurityAndRegulatoryInformation) && Objects.equals(otherServiceInformation, that.otherServiceInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airWaybillNumber, originAndDestination, quantity, totalNumberOfPieces, events, truckingEvents, otherCustomsSecurityAndRegulatoryInformation, otherServiceInformation);
    }
}
