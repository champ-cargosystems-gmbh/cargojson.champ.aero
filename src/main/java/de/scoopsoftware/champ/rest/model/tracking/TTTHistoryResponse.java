package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.flightstatus.FlightHistory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class TTTHistoryResponse {

    public final Optional<FlightHistory> flightHistory;
    public final ResponseCode responseCode;
    @JsonIgnore
    public final LocalDateTime lastDataFromDb;

    @JsonCreator
    public TTTHistoryResponse(@JsonProperty("flightHistory") FlightHistory flightHistory, @JsonProperty("responseCode") ResponseCode responseCode) {
        this(flightHistory, responseCode, null);
    }

    public TTTHistoryResponse(FlightHistory flightHistory, ResponseCode responseCode, LocalDateTime lastDataFromDb) {
        this.flightHistory = Optional.ofNullable(flightHistory);
        this.responseCode = responseCode;
        this.lastDataFromDb = lastDataFromDb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TTTHistoryResponse)) return false;
        TTTHistoryResponse that = (TTTHistoryResponse) o;
        return Objects.equals(flightHistory, that.flightHistory) && responseCode == that.responseCode && Objects.equals(lastDataFromDb, that.lastDataFromDb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightHistory, responseCode, lastDataFromDb);
    }
}