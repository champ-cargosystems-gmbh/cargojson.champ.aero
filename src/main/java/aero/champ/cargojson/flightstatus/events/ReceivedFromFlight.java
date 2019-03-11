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
@JsonClassDescription("This event reports that the consignment was received from a flight.\nConforms to CIMP FSU status 'RCF'.")
public class ReceivedFromFlight extends FlightEvent {
    public ReceivedFromFlight(){}

    @JsonPropertyDescription("The flight the consignment was received from.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The date the consignment was received at.")
    public LocalDate dateOfScheduledArrival;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The destination airport of the consignment.")
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