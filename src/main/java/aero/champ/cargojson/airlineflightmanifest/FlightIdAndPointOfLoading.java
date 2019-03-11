package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.Flight;
import aero.champ.cargojson.common.IATAAirportCode;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Describes the flight and the point of unloading")
public class FlightIdAndPointOfLoading {

    @JsonProperty(required = true)
    public Flight flightIdentification;
    @JsonProperty(required = true)
    public IATAAirportCode airportCode;
    public Optional<String> aircraftRegistration = Optional.empty();
    public Optional<FirstPointOfArrivalInformation> firstPointOfArrivalInformation = Optional.empty();

}
