package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.*;
import aero.champ.cargojson.flightstatus.events.*;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import aero.champ.cargojson.validation.ValidationContext;
import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.ScopedValue;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Discrepancy.class, name = "discrepancy"),
        @JsonSubTypes.Type(value = ArrivalDocumentationDelivered.class, name = "arrival documentation delivered"),
        @JsonSubTypes.Type(value = ArrivalDocumentationReceived.class, name = "arrival documentation received"),
        @JsonSubTypes.Type(value = ConsigneeNotified.class, name = "consignee notified"),
        @JsonSubTypes.Type(value = Arrived.class, name = "arrived"),
        @JsonSubTypes.Type(value = Booked.class, name = "booked"),
        @JsonSubTypes.Type(value = CustomsCleared.class, name = "customs cleared"),
        @JsonSubTypes.Type(value = CustomsError.class, name = "customs error"),
        @JsonSubTypes.Type(value = CustomsOnHold.class, name = "customs on hold"),
        @JsonSubTypes.Type(value = TransferManifested.class, name = "transfer manifested"),
        @JsonSubTypes.Type(value = Manifested.class, name = "manifested"),
        @JsonSubTypes.Type(value = Delivered.class, name = "delivered"),
        @JsonSubTypes.Type(value = DeliveredAtDoor.class, name = "delivered at door"),
        @JsonSubTypes.Type(value = ReceivedFromFlight.class, name = "received from flight"),
        @JsonSubTypes.Type(value = ReceivedFromShipper.class, name = "received from shipper"),
        @JsonSubTypes.Type(value = ReceivedFromCarrier.class, name = "received from carrier"),
        @JsonSubTypes.Type(value = TransferredToCarrier.class, name = "transferred to carrier"),
        @JsonSubTypes.Type(value = FreightPrepared.class, name = "freight prepared"),
        @JsonSubTypes.Type(value = ReportedToCustoms.class, name = "reported to customs"),
        @JsonSubTypes.Type(value = TransferredToCustoms.class, name = "transferred to customs"),
        @JsonSubTypes.Type(value = Departed.class, name = "departed"),
        @JsonSubTypes.Type(value = FreightOnHand.class, name = "freight on hand"),
        @JsonSubTypes.Type(value = InFlight.class, name = "in flight"),
        @JsonSubTypes.Type(value = FreightInWarehouse.class, name = "freight in warehouse"),
        @JsonSubTypes.Type(value = FreightOutWarehouse.class, name = "freight out warehouse"),
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(subTypes = {Discrepancy.class, ArrivalDocumentationDelivered.class, ArrivalDocumentationReceived.class, ConsigneeNotified.class, Arrived.class, Booked.class, CustomsCleared.class, CustomsError.class, CustomsOnHold.class, TransferManifested.class, Manifested.class, Delivered.class, DeliveredAtDoor.class, ReceivedFromFlight.class, ReceivedFromShipper.class, ReceivedFromCarrier.class, TransferredToCarrier.class, FreightPrepared.class, ReportedToCustoms.class, TransferredToCustoms.class, Departed.class, FreightOnHand.class, InFlight.class, FreightInWarehouse.class, FreightOutWarehouse.class})
@JsonClassDescription("Base type representing common data of a flight event. A flight event is a new status in " +
    "the shipment process of a consignment. This is a polymorphic type. The concrete subclass is determined by " +
    "the 'type' property (e.g. 'arrived', 'booked', 'customs cleared', etc.). " +
    "the shipment process of a consignment.")
public abstract class FlightEvent {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of pieces of the consignment this flight event belongs to.")
    @Schema(description = "Number of pieces of the consignment this flight event belongs to.", example = "12")
    public BigInteger numberOfPieces;

    @JsonPropertyDescription("Weight of the consignment this flight event belongs to.")
    @Schema(description="Weight of the consignment this flight event belongs to.")
    public Optional<Weight> weight = Optional.empty();

    @JsonPropertyDescription("Unit Load Device (ULD) data.")
    @Schema(description="Unit Load Device (ULD) data.")
    public List<ULD> uld = new ArrayList<>();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date and time when this event was created or reported.")
    @Schema(description = "Date and time when this event was created or reported.")
    public LocalDateTime timeOfEvent;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Certain sources might not convey the time part of the event. This field shows the quality of the time information in timeOfEvent")
    @Schema(description = "Certain sources might not convey the time part of the event. This field shows the quality of the time information in timeOfEvent")
    public DataQuality timeOfEventTimePartQuality = DataQuality.SUPPLIED;


    public Optional<CargoImpFlightEventData> cargoImp = Optional.empty();
    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    public void validateCargoImp(ValidationContext validationContext) {
        validationContext.checkSize(uld, 0, 5, "uld");
    }

    public <V extends FlightEvent> Optional<V> narrow(Class<V> clazz) {
        if (clazz.isAssignableFrom(this.getClass()))
            return Optional.of((V) this);
        return Optional.empty();
    }

    public abstract Optional<IATAAirportCode> airportOfEvent();

    public abstract Optional<FlightIdentity> flight();

    @Override
    public String toString() {
        return DefaultObjectMapperBuilder.globalMapper().writeValueAsString(this);
    }

    public Optional<LocalDateTime> departureDate() {
        return Optional.empty();
    }

    public Optional<LocalDateTime> arrivalDate() {
        return Optional.empty();
    }
}