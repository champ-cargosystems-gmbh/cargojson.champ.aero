package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was delivered at the consignee's door.\nConforms to CIMP FSU status 'DDL'.")
public class DeliveredAtDoor extends FlightEvent {
    public DeliveredAtDoor(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was delivered.")
    public IATAAirportCode airportOfDelivery;

    @JsonPropertyDescription("The name of the individual or company the consignment has been delivered to.")
    @JsonDocExample("K. Wilson, Supersonic Shipping Co.")
    public Optional<String> deliveryToName = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfDelivery);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
