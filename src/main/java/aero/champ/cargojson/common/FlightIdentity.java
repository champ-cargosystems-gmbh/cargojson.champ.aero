package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.ValidationException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JsonClassDescription("Flight identification.")
public class FlightIdentity implements Comparable<FlightIdentity> {

    static final Pattern FLIGHT_NUMBER_PATTERN = Pattern.compile("((?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z]))([0-9]{1,4})([A-Z])?");

    @JsonCreator
    public FlightIdentity(
            @javax.validation.constraints.Pattern(regexp = "(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])[0-9]{1,4}[A-Z]?")
                    String flightIdentification) {
        this.flightIdentification = normalize(flightIdentification);
    }

    private String normalize(String flightIdentification) {
        Matcher m = FLIGHT_NUMBER_PATTERN.matcher(flightIdentification);
        if (!m.matches())
            throw new ValidationException("Flight identification '"+flightIdentification+"' invalid");
        String g2 = m.group(2);
        if (g2.length() > 2)
            return flightIdentification;
        if (g2.length() == 1)
            return m.group(1)+"00"+g2+ Optional.ofNullable(m.group(3)).orElse("");
        return m.group(1)+"0"+g2+ Optional.ofNullable(m.group(3)).orElse("");
    }

    @JsonIgnore
    public final String flightIdentification;

    @JsonValue
    @JsonPropertyDescription("Flight identification string that matches the regular expression\n\"(?:[A-Z][A-Z]|[A-Z][0-9]|[0-9][A-Z])[0-9]{1,4}[A-Z]?\"")
    @JsonDocExample("LH116")
    public String value() {
        return flightIdentification;
    }

    @JsonIgnore
    public IATACarrierCode carrierCode() {
        return new IATACarrierCode(flightIdentification.substring(0,2));
    }

    @JsonIgnore
    public String flightnumber() {
        return flightIdentification.substring(2);
    }

    @JsonIgnore
    public String flightnumberWithoutSuffix() {
        String fn = flightIdentification.substring(2);
        if (Character.isDigit(fn.charAt(fn.length()-1)))
            return fn;
        return fn.substring(0,fn.length()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightIdentity that = (FlightIdentity) o;

        return flightIdentification.equals(that.flightIdentification);
    }

    @Override
    public int hashCode() {
        return flightIdentification.hashCode();
    }

    @Override
    public int compareTo(FlightIdentity o) {
        return flightIdentification.compareTo(o.flightIdentification);
    }

    @Override
    public String toString() {
        return value();
    }
}
