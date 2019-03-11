package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charge Summary - a structure that summarizes charge conditions. " +
        "All values are money in an agreed currency.")
public class ChargeSummary {

    @JsonPropertyDescription("Charge amount for total weight.")
    @JsonDocExample("120.99")
    public Optional<BigDecimal> totalWeightCharge = Optional.empty();

    @JsonPropertyDescription("Valuation charge amount.")
    @JsonDocExample("110.00")
    public Optional<BigDecimal> valuationCharge = Optional.empty();

    @JsonPropertyDescription("Taxes.")
    @JsonDocExample("22.45")
    public Optional<BigDecimal> taxes = Optional.empty();

    @JsonPropertyDescription("Total other charges due agent.")
    @JsonDocExample("32.95")
    public Optional<BigDecimal> totalOtherChargesDueAgent = Optional.empty();

    @JsonPropertyDescription("Total other charges due carrier.")
    @JsonDocExample("43.00")
    public Optional<BigDecimal> totalOtherChargesDueCarrier = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total charges.")
    @JsonDocExample("329.39")
    public final BigDecimal chargeSummaryTotal;

    @JsonCreator
    public ChargeSummary(@JsonProperty(value = "chargeSummaryTotal", required = true) BigDecimal chargeSummaryTotal) {
        this.chargeSummaryTotal = chargeSummaryTotal;
    }

}
