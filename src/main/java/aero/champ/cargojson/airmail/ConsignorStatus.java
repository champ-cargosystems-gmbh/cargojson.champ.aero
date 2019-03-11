package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsignorStatus {
    @JsonProperty(required = true)
    public String consignorStatusCode;
    // if consignor status code is AC, then we have consignor name reference
    // else we have consignor id
    public String consignorId;
    public String consignorNameReference;
}
