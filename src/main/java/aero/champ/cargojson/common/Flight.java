package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Flight data.")
public class Flight {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Flight identity.")
    public FlightIdentity flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Scheduled date of the flight.")
    public LocalDate scheduledDate;

    @JsonPropertyDescription("Scheduled time of the flight.")
    public Optional<LocalTime> scheduledTime = Optional.empty();

}
