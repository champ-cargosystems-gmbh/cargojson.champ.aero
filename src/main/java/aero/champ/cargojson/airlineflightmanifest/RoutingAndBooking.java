package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.Routing;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoutingAndBooking {
    public Optional<Routing> routing = Optional.empty();
    public Optional<Booking> booking = Optional.empty();
}
