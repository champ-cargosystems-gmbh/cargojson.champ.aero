package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@JsonClassDescription("Customs Action Code")
@Schema(description = "Customs Action Code")
public class CustomsActionCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public CustomsActionCode(@Pattern(regexp = "(?:[0-9]{3})") String code) {
        this.code = code;
    }

    @JsonValue
    @Schema(example = "123")
    public String code() {
        return code;
    }
}
