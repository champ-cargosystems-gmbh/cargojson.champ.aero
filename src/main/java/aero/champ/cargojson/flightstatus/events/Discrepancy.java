package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.DiscrepancyCode;
import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports a consignment with a discrepancy.\nConforms to CIMP FSU status 'DIS'.")
public class Discrepancy extends FlightEvent {
    public Discrepancy(){}

    @JsonPropertyDescription("The flight the discrepancy is related to.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport the discrepancy is related to.")
    public IATAAirportCode airportOfDiscrepancy;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Coded representation of the discrepancy.")
    public DiscrepancyCode discrepancyCode;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfDiscrepancy);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }


}
