package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;

@JsonClassDescription("Coded identification approved by IATA for a carrier.")
public class IATACarrierCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public IATACarrierCode(@Pattern(regexp = "(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Code matching the regular expression:\n(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])")
    @JsonDocExample("BA")
    public String code() {
        return code;
    }
}
