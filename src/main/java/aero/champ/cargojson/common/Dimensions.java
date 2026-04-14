package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Dimension details of shipped goods.")
@Schema(description = "Dimension details of shipped goods.")
public class Dimensions {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Measurement unit of the dimension values.")
    @Schema(description="Measurement unit of the dimension values.")
    public final LengthUnit unit;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Length value.")
    @Schema(description = "Length value.", example = "200")
    public final int length;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Width value.")
    @Schema(description = "Width value.", example = "150")
    public final int width;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Height value.")
    @Schema(description = "Height value.", example = "100")
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
