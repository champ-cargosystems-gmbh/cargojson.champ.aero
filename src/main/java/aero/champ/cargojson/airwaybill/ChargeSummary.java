package aero.champ.cargojson.airwaybill;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charge Summary - a structure that summarizes charge conditions. " +
        "All values are money in an agreed currency.")
public class ChargeSummary {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total charges.")
    @Schema(description = "Total charges.", example = "329.39")
    public final BigDecimal chargeSummaryTotal;
    @JsonPropertyDescription("Charge amount for total weight.")
    @Schema(description = "Charge amount for total weight.", example = "120.99")
    public Optional<BigDecimal> totalWeightCharge = Optional.empty();
    @JsonPropertyDescription("Valuation charge amount.")
    @Schema(description = "Valuation charge amount.", example = "110.00")
    public Optional<BigDecimal> valuationCharge = Optional.empty();
    @JsonPropertyDescription("Taxes.")
    @Schema(description = "Taxes.", example = "22.45")
    public Optional<BigDecimal> taxes = Optional.empty();
    @JsonPropertyDescription("Total other charges due agent.")
    @Schema(description = "Total other charges due agent.", example = "32.95")
    public Optional<BigDecimal> totalOtherChargesDueAgent = Optional.empty();
    @JsonPropertyDescription("Total other charges due carrier.")
    @Schema(description = "Total other charges due carrier.", example = "43.00")
    public Optional<BigDecimal> totalOtherChargesDueCarrier = Optional.empty();

    @JsonCreator
    public ChargeSummary(@JsonProperty(value = "chargeSummaryTotal", required = true) BigDecimal chargeSummaryTotal) {
        this.chargeSummaryTotal = chargeSummaryTotal;
    }

}
