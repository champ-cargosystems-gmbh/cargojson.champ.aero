package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@JsonClassDescription("This structure holds the volume data of a shipment.")
@Schema(description = "This structure holds the volume data of a shipment.")
public class Volume {


    @JsonCreator
    public Volume(@JsonProperty(required = true, value = "amount") BigDecimal amount,
                  @JsonProperty(required = true, value = "unit") VolumeUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }


    @JsonProperty(required = true)
    @JsonPropertyDescription("Amount of volume units.")
    @Schema(description = "Amount of volume units.", example = "250")
    public final BigDecimal amount;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Unit of the reported volume amount.")
    @Schema(description="Unit of the reported volume amount.")
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
