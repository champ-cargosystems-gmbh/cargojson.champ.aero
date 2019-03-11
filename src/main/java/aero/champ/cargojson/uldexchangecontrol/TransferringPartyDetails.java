package aero.champ.cargojson.uldexchangecontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferringPartyDetails {
    @JsonProperty(required = true)
    public String carrierCode;
    public String nonCarrierIdentifier;
}
