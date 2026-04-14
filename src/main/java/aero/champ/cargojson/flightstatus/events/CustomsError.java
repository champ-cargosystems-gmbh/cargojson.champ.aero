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
@JsonClassDescription("This event reports that the consignment was reported as erroneous by customs.")
@Schema(description = "This event reports that the consignment was reported as erroneous by customs.")
public class CustomsError extends CustomsEvent {
    public CustomsError(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was cleared by customs.")
    @Schema(description="The airport where the consignment was cleared by customs.")
    public IATAAirportCode airportOfError;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(airportOfError);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}
