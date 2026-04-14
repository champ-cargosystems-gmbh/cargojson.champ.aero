package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@JsonClassDescription("Customs Status Code")
@Schema(description = "Customs Status Code")
public class CustomsStatusCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public CustomsStatusCode(@Pattern(regexp = "(?:[A-Z]{2})") String code) {
        this.code = code;
    }

    @JsonValue
    @Schema(example = "CC")
    public String code() {
        return code;
    }
}
