package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.Routing;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoutingAndBooking {
    public Optional<Routing> routing = Optional.empty();
    public Optional<Booking> booking = Optional.empty();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutingAndBooking that = (RoutingAndBooking) o;
        return Objects.equals(routing, that.routing) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routing, booking);
    }
}
