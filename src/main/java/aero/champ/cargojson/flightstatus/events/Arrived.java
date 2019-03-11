package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment is arrived.\nConforms to CIMP FSU status 'ARR'.")
public class Arrived extends FlightEvent {

    public Arrived(){}

    @JsonPropertyDescription("The flight the consignment is or was loaded on.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date of scheduled arrival of the flight.")
    public LocalDate dateOfScheduledArrival;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The destination airport of the flight.")
    public IATAAirportCode destination;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(destination);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }


}
