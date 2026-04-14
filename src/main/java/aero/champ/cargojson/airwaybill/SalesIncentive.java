package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.CASSIndicator;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Sales incentive information.")
@Schema(description = "Sales incentive information.")
public class SalesIncentive {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Sales incentive charge amount.")
    @Schema(description = "Sales incentive charge amount.", example = "20.00")
    public BigDecimal chargeAmount;

    @JsonPropertyDescription("CASS Indicator.")
    @Schema(description="CASS Indicator.")
    public Optional<CASSIndicator> cassIndicator = Optional.empty();

}
