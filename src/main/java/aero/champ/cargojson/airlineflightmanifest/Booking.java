package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.FlightNumber;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Objects;

@JsonClassDescription("Specifies the booked flight")
@Schema(description = "Specifies the booked flight")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(flightNumber, booking.flightNumber) && Objects.equals(dateOfDeparture, booking.dateOfDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, dateOfDeparture);
    }


}
