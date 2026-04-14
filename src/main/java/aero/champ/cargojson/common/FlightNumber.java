package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

import java.util.Optional;
import java.util.regex.Matcher;

public class FlightNumber {

    static final java.util.regex.Pattern EXTRACT_FLIGHT_NUMBER = java.util.regex.Pattern.compile("([0-9]+)");
    @JsonIgnore
    public final String number;

    @JsonCreator
    public FlightNumber(@Pattern(regexp = "[0-9]{1,4}[A-Z]?") String flightNumber) {
        this.number = flightNumber;
    }

    @JsonValue
    @Schema(example = "116")
    public String flightNumber() {
        return number;
    }

    public int flightNumberWithoutOperationalSuffix() {
        Matcher m = EXTRACT_FLIGHT_NUMBER.matcher(number);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        throw new IllegalStateException("Flight number corrupted: '" + number + "'");
    }

    static final java.util.regex.Pattern EXTRACT_SUFFIX = java.util.regex.Pattern.compile("[0-9]+([A-Z])");
    public Optional<String> operationalSuffix() {
        Matcher m = EXTRACT_SUFFIX.matcher(number);
        if (m.find()) {
            return Optional.of(m.group(1));
        }
        return Optional.empty();
    }

}
