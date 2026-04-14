package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Product information.")
@Schema(description = "Product information.")
public class ProductInformation {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Service code.")
    @Schema(description="Service code.")
    public ServiceCode serviceCode;

    @JsonPropertyDescription("Rate class code.")
    @Schema(description="Rate class code.")
    public Optional<RateClassCode> rateClassCode = Optional.empty();

    @JsonPropertyDescription("Commodity item number: Number to identify a specific commodity.")
    @Schema(description = "Commodity item number: Number to identify a specific commodity.", example = "9017")
    public Optional<String> commodityItemNumber = Optional.empty();

    @JsonPropertyDescription("ULD rate class type: Coded description of a Unit Load Device rate class.")
    @Schema(description = "ULD rate class type: Coded description of a Unit Load Device rate class.", example = "8")
    public Optional<String> uldRateClassType = Optional.empty();

    @JsonPropertyDescription("Basis rate class code.")
    @Schema(description="Basis rate class code.")
    public Optional<RateClassCode> rateClassCodeBasis = Optional.empty();

    @JsonPropertyDescription("Class rate percentage A surcharge or discount percentage applied to an applicable rate or charge.")
    @Schema(description = "Class rate percentage A surcharge or discount percentage applied to an applicable rate or charge.", example = "67")
    public Optional<Integer> classRatePercentage = Optional.empty();
}
