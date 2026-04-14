package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@JsonClassDescription("Transfer manifest number: Identification number allocated to each transfer manifest or substitute flight manifest.")
@Schema(description = "Transfer manifest number: Identification number allocated to each transfer manifest or substitute flight manifest.")
public class TransferManifestNumber {

    @JsonIgnore
    public final String number;

    @JsonCreator
    public TransferManifestNumber(@Pattern(regexp = "[0-9]{1,6}") String number) {
        this.number = number;
    }

    @JsonValue
    @JsonPropertyDescription("Value of the transfer manifest number.")
    @Schema(description = "Value of the transfer manifest number.", example = "123456")
    public String number() {
        return number;
    }
}
