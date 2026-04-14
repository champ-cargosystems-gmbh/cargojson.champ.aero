package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was held by customs.\n")
@Schema(description = "This event reports that the consignment was held by customs.\n")
public class CustomsOnHold extends CustomsEvent {
    public CustomsOnHold(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was held by customs.")
    @Schema(description="The airport where the consignment was held by customs.")
    public IATAAirportCode airportOfHold;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(airportOfHold);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
