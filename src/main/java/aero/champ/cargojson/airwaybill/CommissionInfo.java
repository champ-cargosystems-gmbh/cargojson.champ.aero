package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Commission information concerning CASS settlement. A CASS settlement factor is a " +
        "special rate or charge agreed bilaterally between an " +
        "airline and a cargo agent for individual transactions.")
public class CommissionInfo {

    @JsonPropertyDescription("Commisson amount CASS settlement factor.")
    @JsonDocExample("139")
    public Optional<BigDecimal> amountCASSSettlementFactor = Optional.empty();

    @JsonPropertyDescription("Percentage CASS settlement factor.")
    @JsonDocExample("12")
    public Optional<BigDecimal> percentageCASSSettlementFactor = Optional.empty();

}
