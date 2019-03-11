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
@JsonClassDescription("This event reports that the consignment was reported to customs.\nConforms to CIMP FSU status 'CRC'.")
public class ReportedToCustoms extends FlightEvent {
    public ReportedToCustoms(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was reported to customs.")
    public IATAAirportCode airportOfReporting;

    @JsonPropertyDescription("The flight the consignment is or was loaded on.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonPropertyDescription("The scheduled departure date of the flight.")
    public Optional<LocalDate> dateOfScheduledDeparture = Optional.empty();

    @JsonPropertyDescription("The origin airport of the flight.")
    public Optional<IATAAirportCode> origin = Optional.empty();

    @JsonPropertyDescription("The destination airport of the flight.")
    public Optional<IATAAirportCode> destination = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfReporting);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }


}
