package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event expresses that the consignment is or was airborne at the reported event time. " +
        "This is live information gathered from flight tracking systems. All dates and times are based on UTC timezone.")
public class InFlight extends FlightEvent {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airborne flight.")
    @Schema(description = "The airborne flight.")
    public FlightIdentity flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin airport of the flight.")
    @Schema(description = "Origin airport of the flight.")
    public IATAAirportCode origin;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Destination airport of the flight.")
    @Schema(description = "Destination airport of the flight.")
    public IATAAirportCode destination;
    @JsonPropertyDescription("The scheduled departure date and time of the flight.")
    @Schema(description = "The scheduled departure date and time of the flight.")
    public Optional<LocalDateTime> scheduledTimeOfDeparture = Optional.empty();
    @JsonPropertyDescription("The scheduled arrival date and time of the flight.")
    @Schema(description = "The scheduled arrival date and time of the flight.")
    public Optional<LocalDateTime> scheduledTimeOfArrival = Optional.empty();
    @JsonPropertyDescription("The actual departure date and time of the flight.")
    @Schema(description = "The actual departure date and time of the flight.")
    public Optional<LocalDateTime> actualTimeOfDeparture = Optional.empty();
    @JsonPropertyDescription("The estimated arrival date and time of the flight.")
    @Schema(description = "The estimated arrival date and time of the flight.")
    public Optional<LocalDateTime> estimatedTimeOfArrival = Optional.empty();
    @JsonPropertyDescription("The actual arrival date and time of the flight.")
    @Schema(description = "The actual arrival date and time of the flight.")
    public Optional<LocalDateTime> actualTimeOfArrival = Optional.empty();
    @JsonPropertyDescription("The planned flight time of the flight in minutes.")
    @Schema(description = "The planned flight time of the flight in minutes.", example = "320")
    public Optional<Integer> plannedflightTime = Optional.empty();
    @JsonPropertyDescription("The estimated difference between scheduled and actual time of arrival of the flight in minutes. " +
            "In other words: the delay.")
    @Schema(description = "The estimated difference between scheduled and actual time of arrival of the flight in minutes. " +
            "In other words: the delay.", example = "25")
    public Optional<Integer> estimatedDiffToSchedule = Optional.empty();
    @JsonPropertyDescription("Current longitude of the airborne vehicle.")
    @Schema(description = "Current longitude of the airborne vehicle.", example = "2.3161")
    public double ecefLongitude;
    @JsonPropertyDescription("Current latitude of the airborne vehicle.")
    @Schema(description = "Current latitude of the airborne vehicle.", example = "48.7199")
    public double ecefLatitude;

    public InFlight() {
    }

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.empty();
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.of(flight);
    }

    @Override
    public Optional<LocalDateTime> departureDate() {
        return Optional.ofNullable(
                actualTimeOfDeparture
                        .orElseGet(()-> scheduledTimeOfDeparture.orElse(null)
                        ));
    }

    @Override
    public Optional<LocalDateTime> arrivalDate() {
        return Optional.ofNullable(
                actualTimeOfArrival
                        .orElseGet(()-> estimatedTimeOfArrival
                                .orElseGet(()-> scheduledTimeOfArrival.orElse(null))
                        ));
    }
}
