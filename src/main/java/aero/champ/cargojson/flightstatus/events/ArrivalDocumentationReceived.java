package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment arrival documents have been received by the consignee or agent.\n"+
        "Conforms to CIMP FSU status 'AWR'.")
@JsonIgnoreProperties("quantity")
public class ArrivalDocumentationReceived extends FlightEvent {

    public ArrivalDocumentationReceived(){}

    @JsonPropertyDescription("The flight related to the arrival documents.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The scheduled arrival date of the flight.")
    public LocalDate dateOfScheduledArrival;

    @JsonPropertyDescription("The actual arrival time of the flight.")
    public Optional<LocalDateTime> actualTimeOfArrival = Optional.empty();

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
