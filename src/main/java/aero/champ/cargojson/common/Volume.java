package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

@JsonClassDescription("This structure holds the volume data of a shipment.")
public class Volume {


    @JsonCreator
    public Volume(@JsonProperty(required = true, value = "amount") BigDecimal amount,
                  @JsonProperty(required = true, value = "unit") VolumeUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }


    @JsonProperty(required = true)
    @JsonPropertyDescription("Amount of volume units.")
    @JsonDocExample("250")
    public final BigDecimal amount;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Unit of the reported volume amount.")
    public final VolumeUnit unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;

        if (!amount.stripTrailingZeros().equals(volume.amount.stripTrailingZeros())) return false;
        return unit == volume.unit;
    }

    @Override
    public int hashCode() {
        int result = amount.stripTrailingZeros().hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }


}
