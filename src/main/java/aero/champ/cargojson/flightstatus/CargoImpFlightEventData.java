package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.TimeInformation;

import java.time.LocalDateTime;
import java.util.Optional;

public class CargoImpFlightEventData {

    public Optional<CargoImpTimeInformation> timeOfArrival = Optional.empty();
    public Optional<CargoImpTimeInformation> timeOfDeparture = Optional.empty();
    public CargoImpTimeInformation timeOfEvent;

}
