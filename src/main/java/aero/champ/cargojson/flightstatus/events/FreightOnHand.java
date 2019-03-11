package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.DensityGroup;
import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.Volume;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the freight is on hand.\nConforms to CIMP FSU status 'FOH'.")
public class FreightOnHand extends FlightEvent {
    public FreightOnHand(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was received.")
    public IATAAirportCode airportOfReceipt;

    @JsonPropertyDescription("The name of the individual or company the freight has been received from.")
    @JsonDocExample("K. Wilson, Supersonic Shipping Co.")
    public Optional<String> receivedFromName = Optional.empty();

    @JsonPropertyDescription("The volume of the freight.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("The density group of the freight.")
    public Optional<DensityGroup> densityGroup = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfReceipt);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
