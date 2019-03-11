package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;

@JsonClassDescription("Customs Status Code")
public class CustomsStatusCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public CustomsStatusCode(@Pattern(regexp = "(?:[A-Z]{2})") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonDocExample("CC")
    public String code() {
        return code;
    }
}
