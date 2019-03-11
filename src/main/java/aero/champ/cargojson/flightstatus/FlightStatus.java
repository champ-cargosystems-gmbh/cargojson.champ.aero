package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.events.OtherCustomsSecurityAndRegulatoryInformation;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Flight Status indicates a status in the movement of the nominated consignment.")
public class FlightStatus implements Serializable {

    private static final long serialVersionUID = 1l;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonPropertyDescription("Origin and destination airports of the consigment.")
    public Optional<OriginAndDestination> originAndDestination = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Quantity details of the consigment.")
    public Quantity quantity;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total number of pieces of the consignment.")
    @JsonDocExample("20")
    public BigInteger totalNumberOfPieces;

    @JsonPropertyDescription("Array of flight events related to the flight status. Will often be only one event.")
    public List<FlightEvent> events = new ArrayList<>();

    @JsonPropertyDescription("Other customs, security and regulatory information.")
    public Optional<OtherCustomsSecurityAndRegulatoryInformation> otherCustomsSecurityAndRegulatoryInformation = Optional.empty();

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
        FlightStatus msg = DefaultObjectMapperBuilder.globalMapper().readValue(json,FlightStatus.class);
        this.airWaybillNumber = msg.airWaybillNumber;
        this.originAndDestination = msg.originAndDestination;
        this.quantity = msg.quantity;
        this.totalNumberOfPieces = msg.totalNumberOfPieces;
        this.events = msg.events;
        this.otherCustomsSecurityAndRegulatoryInformation = msg.otherCustomsSecurityAndRegulatoryInformation;
        this.otherServiceInformation = msg.otherServiceInformation;
    }



}
