package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.ChargeCode;
import aero.champ.cargojson.common.PaymentCondition;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charge Declarations.")
public class ChargeDeclarations {

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO currency code: Coded representation of a currency approved by ISO.")
    @JsonDocExample("GBP")
    public String isoCurrencyCode;

    @JsonPropertyDescription("Charge Code: Code identifying a method of payment of charges.")
    public Optional<ChargeCode> chargeCode = Optional.empty();

    @JsonPropertyDescription("Prepaid/Collect indicator for weight valuation.")
    public Optional<PaymentCondition> payment_WeightValuation = Optional.empty();

    @JsonPropertyDescription("Prepaid/Collect indicator for other charges.")
    public Optional<PaymentCondition> payment_OtherCharges = Optional.empty();

    @JsonPropertyDescription("Declared value for carriage. The value of a shipment declared for carriage purposes.")
    @JsonDocExample("100.00")
    public Optional<BigDecimal> declaredValueForCarriage = Optional.empty();

    @JsonPropertyDescription("Declared value for customs. The value of a shipment for customs purposes.")
    @JsonDocExample("120.00")
    public Optional<BigDecimal> declaredValueForCustoms = Optional.empty();

    @JsonPropertyDescription("Amount of insurance. The value of a shipment for insurance purposes.")
    @JsonDocExample("1000.00")
    public Optional<BigDecimal> declaredValueForInsurance = Optional.empty();
}
