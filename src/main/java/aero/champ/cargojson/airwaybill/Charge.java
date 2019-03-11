package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.RateClassCode;
import aero.champ.cargojson.common.Weight;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charge related data.")
public class Charge {

    @JsonPropertyDescription("Chargeable weight.")
    public Optional<Weight> chargeableWeight = Optional.empty();

    @JsonPropertyDescription("Code representing the rate category.")
    public Optional<RateClassCode> rateClassCode = Optional.empty();

    @JsonPropertyDescription("Code representing the basis rate category.")
    public Optional<RateClassCode> rateClassCodeBasis = Optional.empty();

    @JsonPropertyDescription("Class rate percentage: A surcharge or discount percentage applied to an applicable rate or charge.")
    @JsonDocExample("67")
    public Optional<BigDecimal> classRatePercentage = Optional.empty();

    @Pattern(regexp = "[0-9][A-Z]{0,2}")
    @JsonPropertyDescription("ULD rate class type: Coded description of a Unit Load Device rate class.\n" +
            "Must match regular expression '[0-9][A-Z]{0,2}'.")
    @JsonDocExample("8")
    public Optional<String> uldRateClassType = Optional.empty();

    @JsonPropertyDescription("Representation of a rate, charge or discount.")
    @JsonDocExample("1234.56")
    public Optional<BigDecimal> rateOrCharge = Optional.empty();

    @JsonPropertyDescription("Total charge amount.")
    @JsonDocExample("2500.00")
    public Optional<BigDecimal> totalChargeAmount = Optional.empty();


}
