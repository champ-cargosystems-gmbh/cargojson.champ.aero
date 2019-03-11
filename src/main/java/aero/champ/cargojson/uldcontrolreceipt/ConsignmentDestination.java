package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ConsignmentDestination {
    @JsonProperty(required = true)
    public String destinationLocationCode;
    public String destinationLocationName;
}
