package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;

@JsonClassDescription("Coded representation of a country approved by ISO.")
public class ISOCountryCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public ISOCountryCode(@Pattern(regexp = "[A-Z]{2}") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Two letter code with uppercase letters from A-Z")
    @JsonDocExample("US")
    public String code() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ISOCountryCode that = (ISOCountryCode) o;

        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
