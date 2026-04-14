package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment arrival documents have been delivered to the consignee or agent.\n" +
        "Conforms to CIMP FSU status 'AWD'.")
@JsonIgnoreProperties("quantity")
public class ArrivalDocumentationDelivered extends FlightEvent {
    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport where the consignment was delivered.")
    @Schema(description = "Airport where the consignment was delivered.")
    public IATAAirportCode airportOfDelivery;
    @JsonPropertyDescription("The name of the individual or company to whom the documents have been delivered.")
    @Schema(description = "The name of the individual or company to whom the documents have been delivered.", example = "K. Wilson, Supersonic Shipping Co.")
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
