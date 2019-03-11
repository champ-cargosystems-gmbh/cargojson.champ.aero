package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.OtherChargeCode;
import aero.champ.cargojson.common.PaymentCondition;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Structure for other charge items.")
public class OtherChargeItem {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Prepaid/Collect indicator.")
    public PaymentCondition paymentCondition;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Other charge code.")
    public OtherChargeCode otherChargeCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Entitlement code.")
    public EntitlementCode entitlementCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Charge amount (money).")
    @JsonDocExample("120.46")
    public BigDecimal chargeAmount;
}
