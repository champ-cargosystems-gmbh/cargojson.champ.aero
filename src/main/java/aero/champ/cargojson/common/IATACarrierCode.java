package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@JsonClassDescription("Coded identification approved by IATA for a carrier.")
@Schema(description = "Coded identification approved by IATA for a carrier.")
public class IATACarrierCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public IATACarrierCode(@Pattern(regexp = "(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Code matching the regular expression:\n(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])")
    @Schema(description = "Code matching the regular expression:\n(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])", example = "BA")
    public String code() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
