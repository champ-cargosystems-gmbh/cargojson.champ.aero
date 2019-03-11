package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.Pattern;
import java.util.Optional;
import java.util.regex.Matcher;

public class FlightNumber {

    @JsonIgnore
    public final String flightNumber;

    @JsonCreator
    public FlightNumber(@Pattern(regexp = "[0-9]{1,4}[A-Z]?") String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonValue
    @JsonDocExample("116")
    public String flightNumber() {
        return flightNumber;
    }

    static final java.util.regex.Pattern EXTRACT_FLIGHTNUMBER = java.util.regex.Pattern.compile("([0-9]+)");
    public int flightNumberWithoutOperationalSuffix() {
        Matcher m = EXTRACT_FLIGHTNUMBER.matcher(flightNumber);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        throw new IllegalStateException("Flight number corrupted: '"+flightNumber+"'");
    }

    static final java.util.regex.Pattern EXTRACT_SUFFIX = java.util.regex.Pattern.compile("[0-9]+([A-Z])");
    public Optional<String> operationalSuffix() {
        Matcher m = EXTRACT_SUFFIX.matcher(flightNumber);
        if (m.find()) {
            return Optional.of(m.group(1));
        }
        return Optional.empty();
    }

}
