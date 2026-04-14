package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.flightstatus.FlightStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TTTBasicResponse {

    @JsonProperty("lastFlightStatus")
    final FlightStatus lastFlightStatus;
    @JsonProperty("responseCode")
    final ResponseCode responseCode;
    @JsonIgnore
    final LocalDateTime lastDataFromDb;

    @JsonCreator
    public TTTBasicResponse(@JsonProperty("lastFlightStatus") FlightStatus lastFlightStatus, @JsonProperty("responseCode") ResponseCode responseCode, @JsonProperty("lastDataFromDb") LocalDateTime lastDataFromDb) {
        this.lastFlightStatus = lastFlightStatus;
        this.responseCode = responseCode;
        this.lastDataFromDb = lastDataFromDb;
    }

    public FlightStatus lastFlightStatus() {
        return lastFlightStatus;
    }

    public ResponseCode responseCode() {
        return responseCode;
    }

    @JsonIgnore
    public LocalDateTime lastDataFromDb() {
        return lastDataFromDb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TTTBasicResponse)) return false;
        TTTBasicResponse that = (TTTBasicResponse) o;
        return Objects.equals(lastFlightStatus, that.lastFlightStatus) && responseCode == that.responseCode && Objects.equals(lastDataFromDb, that.lastDataFromDb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastFlightStatus, responseCode, lastDataFromDb);
    }

    @Override
    public String toString() {
        return "TTTBasicResponse{" +
                "lastFlightStatus=" + lastFlightStatus +
                ", responseCode=" + responseCode +
                ", lastDataFromDb=" + lastDataFromDb +
                '}';
    }
}
