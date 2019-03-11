package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ULDNumberDetails {
    @JsonProperty(required = true)
    public String uldType;
    @JsonProperty(required = true)
    public String uldSerialNumber;
    @JsonProperty(required = true)
    public String uldOwnerCode;

}
