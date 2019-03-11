package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScreeningMethod {
    @JsonProperty(required = true)
    public String screeningMethodCode;
    @JsonProperty(required = true)
    public String screeningMethodApplicableAuthority;
    @JsonProperty(required = true)
    public String screeningMethodApplicableRegulation;
}
