package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;

@JsonClassDescription("ICAO coded identification for carriers")
public class ICAOCarrierCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public ICAOCarrierCode(@Pattern(regexp = "(?:[A-Z]{3})") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Code")
    @JsonDocExample("AFR")
    public String code() {
        return code;
    }
}
