package aero.champ.cargojson.uldexchangecontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceivingPartyDetails {
    @JsonProperty(required = true)
    public String carrierCode;
    public String nonCarrierIdentifier;
}
