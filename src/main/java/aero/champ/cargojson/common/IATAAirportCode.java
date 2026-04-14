package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@JsonClassDescription("Airport code in IATA format.")
@Schema(description = "Airport code in IATA format.")
public class IATAAirportCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public IATAAirportCode(@Pattern(regexp = "[a-zA-Z]{3}") String code) {
        this.code = code;
    }

    @JsonValue
    @JsonPropertyDescription("Three letter IATA style airport code.")
    @Schema(description = "Three letter IATA style airport code.", example = "FRA")
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
