package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicableRegulationInformation {
    @JsonProperty(required = true)
    public String ARTransportDirection;
    @JsonProperty(required = true)
    public List<PreConsigningNotificationAuthorityAndRegulation> preConsigningNotificationAuthorityAndRegulations;
}
