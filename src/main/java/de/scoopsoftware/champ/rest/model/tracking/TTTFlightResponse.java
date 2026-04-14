package de.scoopsoftware.champ.rest.model.tracking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class TTTFlightResponse {

    final FlightState flightState;
    final ResponseCode responseCode;

    @JsonCreator
    public TTTFlightResponse(@JsonProperty("flightState") FlightState flightState, @JsonProperty("responseCode") ResponseCode responseCode) {
        this.flightState = flightState;
        this.responseCode = responseCode;
    }

    public FlightState flightState() {
        return flightState;
    }

    public ResponseCode responseCode() {
        return responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TTTFlightResponse)) return false;
        TTTFlightResponse that = (TTTFlightResponse) o;
        return Objects.equals(flightState, that.flightState) && responseCode == that.responseCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightState, responseCode);
    }
}