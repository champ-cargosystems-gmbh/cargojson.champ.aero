package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 11/30/2017.
 */
public class TransferLocation {
    @JsonProperty(required = true)
    public String transferLocationCode;
    public String getTransferLocationName;
}
