package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

@JsonClassDescription("This structure holds the weight data of a shipment.")
public class Weight {

    @JsonCreator
    public Weight(@JsonProperty(required = true, value = "amount") BigDecimal amount,
                  @JsonProperty(required = true, value = "unit") WeightUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }


    @JsonProperty(required = true)
    @JsonPropertyDescription("Amount of weight units.")
    @JsonDocExample("100")
    public final BigDecimal amount;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Unit of the reported weight amount.")
    public final WeightUnit unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weight weight = (Weight) o;

        if (amount.stripTrailingZeros().compareTo(weight.amount.stripTrailingZeros()) != 0) return false;
        return unit == weight.unit;
    }

    @Override
    public int hashCode() {
        int result = amount.stripTrailingZeros().hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }

    public Weight convert(WeightUnit target) {
        if (target == unit)
            return this;
        BigDecimal newValue = amount.multiply(unit.kilogramEquivalent)
                .divide(target.kilogramEquivalent, 10, BigDecimal.ROUND_HALF_DOWN).setScale(3, BigDecimal.ROUND_HALF_DOWN).stripTrailingZeros();
        return new Weight(newValue, target);
    }

}
