package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.flightstatus.events.InFlight;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class TTTFlightPlusResponse {

    final InFlight inFlight;
    final ResponseCode responseCode;


    @JsonCreator
    public TTTFlightPlusResponse(@JsonProperty("inFlight") InFlight inFlight, @JsonProperty("responseCode") ResponseCode responseCode) {
        this.inFlight = inFlight;
        this.responseCode = responseCode;
    }

    public InFlight inFlight() {
        return inFlight;
    }

    public ResponseCode responseCode() {
        return responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TTTFlightPlusResponse)) return false;
        TTTFlightPlusResponse that = (TTTFlightPlusResponse) o;
        return Objects.equals(inFlight, that.inFlight) && responseCode == that.responseCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inFlight, responseCode);
    }
}