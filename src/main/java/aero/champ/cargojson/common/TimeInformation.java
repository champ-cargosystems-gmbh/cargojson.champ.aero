package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TimeInformation {

    public TimeInformation(
            @JsonProperty(required = true, value = "typeOfTime") TypeOfTimeIndicator typeOfTime,
            @JsonProperty(required = true, value = "time") LocalDateTime time) {
        this.typeOfTime = typeOfTime;
        this.time = time;
    }

    @JsonProperty(required = true)
    public final TypeOfTimeIndicator typeOfTime;

    @JsonProperty(required = true)
    public final LocalDateTime time;


    public TimeInformation plusDays(int days) {
        return new TimeInformation(typeOfTime,time.plusDays(days));
    }

}
