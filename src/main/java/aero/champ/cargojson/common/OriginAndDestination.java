package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Origin and destination airports of a shipment.")
public class OriginAndDestination {

    @JsonCreator
    public OriginAndDestination(
            @JsonProperty(required = true, value = "origin") IATAAirportCode origin,
            @JsonProperty(required = true, value = "destination") IATAAirportCode destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    public final IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    public final IATAAirportCode destination;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OriginAndDestination that = (OriginAndDestination) o;

        if (!origin.equals(that.origin)) return false;
        return destination.equals(that.destination);
    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        return result;
    }
}
