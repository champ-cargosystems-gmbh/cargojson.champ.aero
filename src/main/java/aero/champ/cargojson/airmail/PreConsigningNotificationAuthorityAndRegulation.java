package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreConsigningNotificationAuthorityAndRegulation {
    @JsonProperty(required = true)
    public String ARBorderAgencyAuthority;
    @JsonProperty(required = true)
    public String ARReferenceId;
    @JsonProperty(required = true)
    public String ARFlag;
}
