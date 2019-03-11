package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityStatusDetailedInformation {
    @JsonProperty(required = true)
    public String securityStatusReason;
    public ConsignorStatus consignorStatus = new ConsignorStatus();
    // the following will be stored base on the securityStatusReason
    public ScreeningMethod screeningMethod = new ScreeningMethod();
    public ScreeningExemption screeningExemption = new ScreeningExemption();
}
