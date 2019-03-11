package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ULDOrigin {
    @JsonProperty(required = true)
    public String originLocationCode;
    public String originLocationName;
}
