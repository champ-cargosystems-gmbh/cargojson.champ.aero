package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Flight details.")
public class FlightDetails {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Flight identification data.")
    public Flight flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin and destination airports of the flight.")
    public OriginAndDestination originAndDestination;

    @JsonPropertyDescription("Space allocation code.")
    public Optional<SpaceAllocationCode> spaceAllocationCode = Optional.empty();

    @JsonPropertyDescription("Allotment identification: Reference assigned to guaranteed capacity on one or " +
            "more specific flights on specific date(s) to third parties such as agents and other airlines.")
    @JsonDocExample("MRC7615164")
    public Optional<String> allotmentIdentification = Optional.empty();
}
