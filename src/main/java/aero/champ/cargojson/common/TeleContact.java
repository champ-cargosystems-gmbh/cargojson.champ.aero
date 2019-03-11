package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeleContact {

    @JsonProperty(required = true)
    public TeleContactType teleContactType;
    @JsonProperty(required = true)
    public String address;

}
