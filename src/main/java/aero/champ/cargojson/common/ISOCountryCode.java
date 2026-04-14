package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

import java.util.*;
import java.util.stream.Collectors;

@JsonClassDescription("Coded representation of a country approved by ISO.")
@Schema(description = "Coded representation of a country approved by ISO.")
public class ISOCountryCode {

    @JsonIgnore
    public final String code;

    @JsonCreator
    public ISOCountryCode(@Pattern(regexp = "[A-Z]{2}") String code) {
        if (code != null)
            code = code.toUpperCase();
        if (code != null && code.length() == 3) {
            String replacement = THREE_LETTERS_TO_TWO_LETTERS.get(code);
            if (replacement != null)
                code = replacement;
        }
        this.code = code;
    }

    static final Map<String, String> THREE_LETTERS_TO_TWO_LETTERS;

    static {
        HashMap<String, HashSet<String>> three2two = new HashMap<>();
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getCountry() == null)
                continue;
            try {
                String iso3Country = l.getISO3Country();
                three2two.computeIfAbsent(iso3Country, k -> new HashSet<>()).add(l.getCountry());
            } catch (MissingResourceException ignored) {
            }
        }
        THREE_LETTERS_TO_TWO_LETTERS =
                Collections.unmodifiableMap(three2two.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().iterator().next())));
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

    @JsonValue
    @JsonPropertyDescription("Two letter code with uppercase letters from A-Z")
    @Schema(description = "Two letter code with uppercase letters from A-Z", example = "US")
    public String code() {
        return code;
    }
}
