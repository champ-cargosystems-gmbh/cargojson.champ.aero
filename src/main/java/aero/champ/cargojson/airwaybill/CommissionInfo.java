package aero.champ.cargojson.airwaybill;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Commission information concerning CASS settlement. A CASS settlement factor is a " +
        "special rate or charge agreed bilaterally between an " +
        "airline and a cargo agent for individual transactions.")
public class CommissionInfo {

    @JsonPropertyDescription("Commission amount CASS settlement factor.")
    @Schema(description = "Commission amount CASS settlement factor.", example = "139")
    public Optional<BigDecimal> amountCASSSettlementFactor = Optional.empty();

    @JsonPropertyDescription("Percentage CASS settlement factor.")
    @Schema(description = "Percentage CASS settlement factor.", example = "12")
    public Optional<BigDecimal> percentageCASSSettlementFactor = Optional.empty();

}
