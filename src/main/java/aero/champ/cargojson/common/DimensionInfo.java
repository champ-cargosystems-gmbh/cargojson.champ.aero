package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Dimensions information.")
public class DimensionInfo {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Length dimension.")
    @JsonDocExample("150")
    public Integer length;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Width dimension.")
    @JsonDocExample("200")
    public Integer width;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Height dimension.")
    @JsonDocExample("50")
    public Integer height;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs as accepted for carriage.")
    @JsonDocExample("14")
    public Integer numberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Measurement unit of the dimension values.")
    public LengthUnit measurementUnit;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight details.")
    public Weight weight;
}
