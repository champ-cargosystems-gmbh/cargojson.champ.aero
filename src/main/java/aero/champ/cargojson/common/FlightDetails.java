package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Flight details.")
@Schema(description = "Flight details.")
public class FlightDetails {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Flight identification data.")
    @Schema(description="Flight identification data.")
    public Flight flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin and destination airports of the flight.")
    @Schema(description="Origin and destination airports of the flight.")
    public OriginAndDestination originAndDestination;

    @JsonPropertyDescription("Space allocation code.")
    @Schema(description="Space allocation code.")
    public Optional<SpaceAllocationCode> spaceAllocationCode = Optional.empty();

    @JsonPropertyDescription("Allotment identification: Reference assigned to guaranteed capacity on one or " +
            "more specific flights on specific date(s) to third parties such as agents and other airlines.")
    @Schema(description = "Allotment identification: Reference assigned to guaranteed capacity on one or " +
            "more specific flights on specific date(s) to third parties such as agents and other airlines.", example = "MRC7615164")
    public Optional<String> allotmentIdentification = Optional.empty();
}
