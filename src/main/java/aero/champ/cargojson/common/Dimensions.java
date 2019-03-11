package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Dimension details of shipped goods.")
public class Dimensions {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Measurement unit of the dimension values.")
    public final LengthUnit unit;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Length value.")
    @JsonDocExample("200")
    public final int length;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Width value.")
    @JsonDocExample("150")
    public final int width;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Height value.")
    @JsonDocExample("100")
    public final int height;

    @JsonCreator
    public Dimensions(
            @JsonProperty(value = "unit", required = true) LengthUnit unit,
            @JsonProperty(value = "length", required = true) int length,
            @JsonProperty(value = "width", required = true) int width,
            @JsonProperty(value = "height", required = true) int height) {
        this.unit = unit;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
