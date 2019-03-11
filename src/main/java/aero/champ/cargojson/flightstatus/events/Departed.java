package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the flight the consignment is loaded on has departed.\nConforms to CIMP FSU status 'DEP'.")
public class Departed extends FlightEvent {
    public Departed(){}

    @JsonPropertyDescription("The flight the consignment is loaded on.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The departure date of the flight.")
    public LocalDate dateOfScheduledDeparture;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The origin airport of the flight.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The destination airport of the flight.")
    public IATAAirportCode destination;

    @JsonPropertyDescription("The estimated arrival date and time of the flight.")
    public Optional<LocalDateTime> estimatedTimeOfArrival = Optional.empty();

    @JsonPropertyDescription("The scheduled arrival date and time of the flight.")
    public Optional<LocalDateTime> timeOfScheduledArrival = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(origin);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }


}
