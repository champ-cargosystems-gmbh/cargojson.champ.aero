package aero.champ.cargojson.common;

import aero.champ.cargojson.airlineflightmanifest.AirlineFlightManifestMessage;
import aero.champ.cargojson.airmail.AirmailRequestMessage;
import aero.champ.cargojson.airwaybill.AirWayBillMessage;
import aero.champ.cargojson.confirmationreceipt.ConfirmationReceiptMessage;
import aero.champ.cargojson.consolidation.ConsolidationListMessage;
import aero.champ.cargojson.consolidation.HouseWaybillMessage;
import aero.champ.cargojson.flightstatus.FlightHistoryMessage;
import aero.champ.cargojson.flightstatus.FlightStatusMessage;
import aero.champ.cargojson.flightstatus.FlightStatusRequestMessage;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import aero.champ.cargojson.spaceallocation.SpaceAllocationAnswerMessage;
import aero.champ.cargojson.spaceallocation.SpaceAllocationRequestMessage;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SpaceAllocationRequestMessage.class, name = "space allocation request"),
        @JsonSubTypes.Type(value = FlightStatusMessage.class, name = "flight status"),
        @JsonSubTypes.Type(value = FlightHistoryMessage.class, name = "flight history"),
        @JsonSubTypes.Type(value = AirWayBillMessage.class, name = "air waybill"),
        // TODO check, if this is the right place
        @JsonSubTypes.Type(value = HouseWaybillMessage.class, name = "house waybill"),
        @JsonSubTypes.Type(value = ConfirmationReceiptMessage.class, name = "confirmation receipt"),
        @JsonSubTypes.Type(value = SpaceAllocationAnswerMessage.class, name = "space allocation answer"),
        @JsonSubTypes.Type(value = FlightStatusRequestMessage.class, name = "flight status request"),
        @JsonSubTypes.Type(value = AirmailRequestMessage.class, name = "airmail request"),
        @JsonSubTypes.Type(value = ConsolidationListMessage.class, name = "consolidation list"),
        @JsonSubTypes.Type(value = AirlineFlightManifestMessage.class, name = "flight manifest")
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Cargo Canonical Message base type containing all fields that are common to " +
    "all Cargo Canonical business messages.")
@JsonSerialize(typing = JsonSerialize.Typing.DYNAMIC)
public abstract class Message<T> implements Serializable {

    private static final long serialVersionUID = 1l;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Unique identification of the message.")
    public UUID id = UUID.randomUUID();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The message header.")
    public MessageHeader messageHeader = new MessageHeader();

    @JsonUnwrapped
    @JsonPropertyDescription("The body of the message containing the business payload.")
    public T payload;

    public <V extends Message<?>> Optional<V> narrow(Class<V> clazz) {
        if (clazz.isAssignableFrom(getClass()))
            return Optional.<V>of((V)this);
        return Optional.empty();
    }


    private void writeObject(ObjectOutputStream out)
            throws IOException, ClassNotFoundException {
        out.writeUTF(DefaultObjectMapperBuilder.globalMapper().writeValueAsString(this));
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        String json = stream.readUTF();
        Message<?> msg = DefaultObjectMapperBuilder.globalMapper().readValue(json,Message.class);
        this.payload = (T)msg.payload;
        this.messageHeader = msg.messageHeader;
    }
}
