package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDateTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event expresses that the consignment is or was airborne at the reported event time. " +
    "This is live information gathered from flight tracking systems. All dates and times are based on UTC timezone.")
public class InFlight extends FlightEvent {

    public InFlight(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airborne flight.")
    public FlightIdentity flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin airport of the flight.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Destination airport of the flight.")
    public IATAAirportCode destination;

    @JsonPropertyDescription("The scheduled departure date and time of the flight.")
    public Optional<LocalDateTime> scheduledTimeOfDeparture = Optional.empty();

    @JsonPropertyDescription("The scheduled arrival date and time of the flight.")
    public Optional<LocalDateTime> scheduledTimeOfArrival = Optional.empty();

    @JsonPropertyDescription("The actual departure date and time of the flight.")
    public Optional<LocalDateTime> actualTimeOfDeparture = Optional.empty();

    @JsonPropertyDescription("The estimated arrival date and time of the flight.")
    public Optional<LocalDateTime> estimatedTimeOfArrival = Optional.empty();

    @JsonPropertyDescription("The actual arrival date and time of the flight.")
    public Optional<LocalDateTime> actualTimeOfArrival = Optional.empty();

    @JsonPropertyDescription("The planned flight time of the flight in minutes.")
    @JsonDocExample("320")
    public Optional<Integer> plannedflightTime = Optional.empty();

    @JsonPropertyDescription("The estimated difference between scheduled and actual time of arrival of the flight in minutes. " +
        "In other words: the delay.")
    @JsonDocExample("25")
    public Optional<Integer> estimatedDiffToSchedule = Optional.empty();

    @JsonPropertyDescription("Current longitude of the airborne vehicle.")
    @JsonDocExample("2.3161")
    public double ecefLongitude;

    @JsonPropertyDescription("Current latitude of the airborne vehicle.")
    @JsonDocExample("48.7199")
    public double ecefLatitude;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.empty();
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.of(flight);
    }


}
