package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Created by Andy on 10/16/2017.
 */
public class HandoverDestinationInformation {
    public String handoverDestinationLocationCode;
    public String handoverDestinationLocationCodeSource;
    public String handoverDestinationLocationName;
    @JsonProperty(required = true)
    public LocalDateTime handoverDestinationCutOff;
}
