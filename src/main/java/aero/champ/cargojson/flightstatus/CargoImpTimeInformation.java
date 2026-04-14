package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.TypeOfTimeIndicator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CargoImpTimeInformation {

    public CargoImpTimeInformation(
            @JsonProperty(required = true, value = "typeOfTime") TypeOfTimeIndicator typeOfTime,
            @JsonProperty(required = true, value = "time") LocalDateTime time,
            @JsonProperty(required = false, value = "dayChangeIndicator") CargoImpDayChangeIndicator dayChangeIndicator) {
        this.typeOfTime = typeOfTime;
        this.time = time;
        this.dayChangeIndicator = dayChangeIndicator;
    }

    @JsonProperty(required = true)
    public final TypeOfTimeIndicator typeOfTime;

    @JsonProperty(required = true)
    public final LocalDateTime time;

    public final CargoImpDayChangeIndicator dayChangeIndicator;


    public CargoImpTimeInformation plusDays(int days) {
        return new CargoImpTimeInformation(typeOfTime,time.plusDays(days), dayChangeIndicator);
    }

}