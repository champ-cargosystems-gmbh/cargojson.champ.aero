package aero.champ.cargojson.uldexchangecontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ULDIdentification {
    @JsonProperty(required = true)
    public String ULDType;
    @JsonProperty(required = true)
    public String ULDSerialNumber;
    @JsonProperty(required = true)
    public String ULDOwnerCode;
}
