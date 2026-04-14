package aero.champ.cargojson.booking;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Segment {

    @JsonPropertyDescription("Flight identity.")
    @Schema(description="Flight identity.")
    public FlightIdentity flight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    @Schema(description="Airport code of origin airport.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    @Schema(description="Airport code of destination airport.")
    public IATAAirportCode destination;

    public LocalDate scheduledDepartureDate;

    public LocalTime scheduledDepartureTime;

    public LocalDate scheduledArrivalDate;

    public LocalTime scheduledArrivalTime;


}
