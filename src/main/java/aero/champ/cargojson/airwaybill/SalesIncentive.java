package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.CASSIndicator;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Sales incentive information.")
public class SalesIncentive {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Sales incentive charge amount.")
    @JsonDocExample("20.00")
    public BigDecimal chargeAmount;

    @JsonPropertyDescription("CASS Indicator.")
    public Optional<CASSIndicator> cassIndicator = Optional.empty();

}
