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
@JsonClassDescription("This event reports that the consignment has arrived at destination and that the consignee or agent has been notified.\n"+
        "Conforms to CIMP FSU status 'NFD'.")
public class ConsigneeNotified extends FlightEvent {
    public ConsigneeNotified(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport of the notification.")
    public IATAAirportCode airportOfNotification;

    @JsonPropertyDescription("The name of the individual or company that has been notified.")
    @JsonDocExample("K. Wilson, Supersonic Shipping Co.")
    public Optional<String> notificationToName = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfNotification);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
