package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.ISOCountryCode;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class FirstPointOfArrivalInformation {

    @JsonProperty(required = true)
    public ISOCountryCode isoCountryCode;

    @JsonProperty(required = true)
    public LocalDateTime scheduleArrival;

    @JsonProperty(required = true)
    public IATAAirportCode airportCityCode;
}
