package aero.champ.cargojson.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class PieceDetails {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Length dimension in (centimeters).")
    @Schema(description = "Length dimension in (centimeters).", example = "150")
    public Integer lengthCm;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Width dimension in (centimeters).")
    @Schema(description = "Width dimension in (centimeters).", example = "200")
    public Integer widthCm;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Height dimension (centimeters).")
    @Schema(description = "Height dimension (centimeters).", example = "50")
    public Integer heightCm;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs.")
    @Schema(description = "Number of loose items and/or ULDs.", example = "14")
    public Integer numberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight (kilogram).")
    @Schema(description="Weight (kilogram).")
    public BigDecimal totalWeightKg;


}
