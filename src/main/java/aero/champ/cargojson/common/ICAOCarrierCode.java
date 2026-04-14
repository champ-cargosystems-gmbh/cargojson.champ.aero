package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@JsonClassDescription("ICAO coded identification for carriers")
@Schema(description = "ICAO coded identification for carriers")
public class ICAOCarrierCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public ICAOCarrierCode(@Pattern(regexp = "(?:[A-Z]{3})") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Code")
    @Schema(description = "Code", example = "AFR")
    public String code() {
        return code;
    }
}
