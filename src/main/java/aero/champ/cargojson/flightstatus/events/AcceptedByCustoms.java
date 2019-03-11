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
public class AcceptedByCustoms extends FlightEvent {
    public AcceptedByCustoms(){}

    @JsonPropertyDescription("The flight the consignment is loaded on.")
    public FlightIdentity flight;

    @JsonPropertyDescription("The scheduled arrival date of the flight.")
    public LocalDate dateOfScheduledArrival;

    @JsonPropertyDescription("The airport of loading.")
    public IATAAirportCode airportOfLoading;

    @JsonPropertyDescription("The destination airport of the flight.")
    public IATAAirportCode airportOfUnloading;

    @JsonPropertyDescription("The airport of first entry.")
    public IATAAirportCode airportOfFirstEntryPoint;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfUnloading);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.of(flight);
    }


}
