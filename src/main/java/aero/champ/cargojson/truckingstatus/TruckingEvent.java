package aero.champ.cargojson.truckingstatus;

import aero.champ.cargojson.common.ULD;
import aero.champ.cargojson.common.Weight;
import aero.champ.cargojson.truckingstatus.events.*;
import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PickedUp.class, name = "picked up"),
        @JsonSubTypes.Type(value = PickedUp1.class, name = "picked up 1"),
        @JsonSubTypes.Type(value = PickedUp2.class, name = "picked up 2"),
        @JsonSubTypes.Type(value = Delivered.class, name = "delivered"),
        @JsonSubTypes.Type(value = Delivered1.class, name = "delivered 1"),
        @JsonSubTypes.Type(value = Delivered2.class, name = "delivered 2"),
        @JsonSubTypes.Type(value = Arrived.class, name = "arrived"),
        @JsonSubTypes.Type(value = Arrived1.class, name = "arrived 1"),
        @JsonSubTypes.Type(value = Arrived2.class, name = "arrived 2"),
        @JsonSubTypes.Type(value = ArrivedForPickup.class, name = "arrived for pickup"),
        @JsonSubTypes.Type(value = ArrivedForPickup1.class, name = "arrived for pickup 1"),
        @JsonSubTypes.Type(value = ArrivedForPickup2.class, name = "arrived for pickup 2"),
        @JsonSubTypes.Type(value = ArrivedForDelivery.class, name = "arrived for delivery"),
        @JsonSubTypes.Type(value = ArrivedForDelivery1.class, name = "arrived for delivery 1"),
        @JsonSubTypes.Type(value = ArrivedForDelivery2.class, name = "arrived for delivery 2"),
        @JsonSubTypes.Type(value = Discrepancy.class, name = "discrepancy"),
        @JsonSubTypes.Type(value = Discrepancy1.class, name = "discrepancy 1"),
        @JsonSubTypes.Type(value = Discrepancy2.class, name = "discrepancy 2"),
        @JsonSubTypes.Type(value = Moving.class, name = "moving")
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Base type representing common data of a trucking event. A trucking event is a new status in " +
        "the shipment process of a consignment. This is a polymorphic type. The specific subclass is determined by " +
        "the 'type' property (e.g. 'picked up', 'delivered', 'moving', etc.). " +
        "the shipment process of a consignment.")
public class TruckingEvent {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of pieces of the consignment this trucking event belongs to.")
    @Schema(description = "Number of pieces of the consignment this trucking event belongs to.", example = "12")
    public BigInteger numberOfPieces;

    @JsonPropertyDescription("Weight of the consignment this trucking event belongs to.")
    @Schema(description="Weight of the consignment this trucking event belongs to.")
    public Optional<Weight> weight = Optional.empty();

    @JsonPropertyDescription("Unit Load Device (ULD) data.")
    @Schema(description="Unit Load Device (ULD) data.")
    public List<ULD> uld = new ArrayList<>();

    @JsonPropertyDescription("fullName")
    @Schema(description="fullName")
    public Optional<String> fullName = Optional.empty();

    @JsonPropertyDescription("discrepancyType")
    @Schema(description="discrepancyType")
    public Optional<String> discrepancyType = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date and time when this event was created or reported.")
    @Schema(description="Date and time when this event was created or reported.")
    public LocalDateTime timeOfEvent;

    @JsonPropertyDescription("The license plate of the truck moving the cargo.")
    @Schema(description="The license plate of the truck moving the cargo.")
    public Optional<String> licensePlate = Optional.empty();

    @JsonPropertyDescription("Current latitude of the truck.")
    @Schema(description = "Current latitude of the truck.", example = "48.7199")
    public Optional<Double> wgs84Latitude = Optional.empty();

    @JsonPropertyDescription("Current longitude of the truck.")
    @Schema(description = "Current longitude of the truck.", example = "2.3161")
    public Optional<Double> wgs84Longitude = Optional.empty();

    @JsonPropertyDescription("Optional image.")
    @Schema(description="Optional image.")
    public Optional<byte[]> imageData = Optional.empty();
}
