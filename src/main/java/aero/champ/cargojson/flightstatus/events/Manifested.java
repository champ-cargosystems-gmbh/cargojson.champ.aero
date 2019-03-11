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
@JsonClassDescription("This event reports that the consignment was manifested on a specific flight.\nConforms to CIMP FSU status 'MAN'.")
public class Manifested extends FlightEvent {
    public Manifested(){}

    @JsonPropertyDescription("The flight the consignment was manifested on.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonPropertyDescription("The departure date of the flight the consignment was manifested on.")
    public Optional<LocalDate> dateOfScheduledDeparture = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The origin airport of the flight.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The destination airport of the flight.")
    public IATAAirportCode destination;

    @JsonPropertyDescription("The scheduled departure date and time of the flight.")
    public Optional<LocalDateTime> timeOfScheduledDeparture = Optional.empty();

    @JsonPropertyDescription("The estimated departure date and time of the flight.")
    public Optional<LocalDateTime> estimatedTimeOfDeparture = Optional.empty();

    @JsonPropertyDescription("The scheduled arrival date and time of the flight.")
    public Optional<LocalDateTime> timeOfScheduledArrival = Optional.empty();

    @JsonPropertyDescription("The estimated arrival date and time of the flight.")
    public Optional<LocalDateTime> estimatedTimeOfArrival = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(origin);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }


}
