package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtherServiceInformation {

    @JsonProperty(required = true)
    public String osi_1;
    public String osi_2;
}
