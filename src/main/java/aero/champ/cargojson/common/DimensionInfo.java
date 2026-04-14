package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@JsonClassDescription("Dimensions information.")
@Schema(description = "Dimensions information.")
public class DimensionInfo {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Length dimension.")
    @Schema(description = "Length dimension.", example = "150")
    public Integer length;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Width dimension.")
    @Schema(description = "Width dimension.", example = "200")
    public Integer width;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Height dimension.")
    @Schema(description = "Height dimension.", example = "50")
    public Integer height;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs as accepted for carriage.")
    @Schema(description = "Number of loose items and/or ULDs as accepted for carriage.", example = "14")
    public Integer numberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Measurement unit of the dimension values.")
    @Schema(description="Measurement unit of the dimension values.")
    public LengthUnit measurementUnit;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight details.")
    @Schema(description="Weight details.")
    public Weight weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimensionInfo that = (DimensionInfo) o;
        return Objects.equals(length, that.length) && Objects.equals(width, that.width) && Objects.equals(height, that.height) && Objects.equals(numberOfPieces, that.numberOfPieces) && measurementUnit == that.measurementUnit && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height, numberOfPieces, measurementUnit, weight);
    }
}
