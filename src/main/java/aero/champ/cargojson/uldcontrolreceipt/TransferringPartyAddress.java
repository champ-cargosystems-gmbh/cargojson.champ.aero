package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 11/30/2017.
 */
public class TransferringPartyAddress {
    @JsonProperty(required = true)
    public StreetDetail streetDetail = new StreetDetail();
    public String department;
    public String postalCode;
    public String regionCode;
    public String regionName;
    public String cityCode;
    public String cityName;
    public String countryCode;
    public String countryName;
}
