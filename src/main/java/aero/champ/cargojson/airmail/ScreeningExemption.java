package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScreeningExemption {
    @JsonProperty(required = true)
    public String screeningExemptionCode;
    @JsonProperty(required = true)
    public String screeningExemptionApplicableAuthority;
    @JsonProperty(required = true)
    public String screeningExemptionApplicableRegulation;
}
