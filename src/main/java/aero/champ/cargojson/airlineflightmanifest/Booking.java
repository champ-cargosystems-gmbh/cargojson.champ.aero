package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.FlightNumber;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonClassDescription("Specifies the booked flight")
public class Booking {

    @JsonCreator
    public Booking(@JsonProperty(value = "flightNumber", required = true) FlightNumber flightNumber, @JsonProperty(value = "dateOfDeparture", required = true) LocalDate dateOfDeparture) {
        this.flightNumber = flightNumber;
        this.dateOfDeparture = dateOfDeparture;
    }

    @JsonProperty(required = true)
    public final FlightNumber flightNumber;
    @JsonProperty(required = true)
    public final LocalDate dateOfDeparture;

}
