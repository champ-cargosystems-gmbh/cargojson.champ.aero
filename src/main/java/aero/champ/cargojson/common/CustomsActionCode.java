package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.Pattern;

@JsonClassDescription("Customs Action Code")
public class CustomsActionCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public CustomsActionCode(@Pattern(regexp = "(?:[0-9]{3})") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonDocExample("123")
    public String code() {
        return code;
    }
}
