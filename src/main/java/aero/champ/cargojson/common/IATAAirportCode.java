package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.Objects;

@JsonClassDescription("Airport code in IATA format.")
public class IATAAirportCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public IATAAirportCode(@Pattern(regexp = "[a-zA-Z]{3}") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonDocExample("FRA")
    @JsonPropertyDescription("Three letter IATA style airport code.")
    public String code() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IATAAirportCode that = (IATAAirportCode) o;

        return Objects.equals(code,that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
