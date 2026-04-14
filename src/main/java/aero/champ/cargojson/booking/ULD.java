package aero.champ.cargojson.booking;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Unit Load Device (ULD).")
@Schema(description = "Unit Load Device (ULD).")
public class ULD {

    @JsonPropertyDescription("Number of units with this type.")
    @Schema(description="Number of units with this type.")
    public Integer numberOfUnits;

    @JsonPropertyDescription("Total weight of the ULD contents (kilogram).")
    @Schema(description="Total weight of the ULD contents (kilogram).")
    public BigDecimal weightKg;

    //What is this?
    public String unitType;
}
