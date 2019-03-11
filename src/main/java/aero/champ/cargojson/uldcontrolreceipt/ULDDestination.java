package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ULDDestination {
    @JsonProperty(required = true)
    public String destinationLocationCode;
    @JsonProperty(required = true)
    public String destinationLocationName;
}
