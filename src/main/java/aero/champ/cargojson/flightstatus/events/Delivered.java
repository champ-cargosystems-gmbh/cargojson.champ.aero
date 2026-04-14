package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was delivered to the consignee or agent.\nConforms to CIMP FSU status 'DLV'.")
@Schema(description = "This event reports that the consignment was delivered to the consignee or agent.\nConforms to CIMP FSU status 'DLV'.")
@JsonIgnoreProperties("quantity")
public class Delivered extends FlightEvent {
    public Delivered(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport of the delivery.")
    @Schema(description="The airport of the delivery.")
    public IATAAirportCode airportOfDelivery;

    @JsonPropertyDescription("The name of the individual or company the consignment has been delivered to.")
    @Schema(description = "The name of the individual or company the consignment has been delivered to.", example = "K. Wilson, Supersonic Shipping Co.")
    public Optional<String> deliveryToName = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(airportOfDelivery);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
