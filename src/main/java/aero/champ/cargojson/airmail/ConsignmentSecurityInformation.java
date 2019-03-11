package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class ConsignmentSecurityInformation {
    @JsonProperty(required = true)
    public String securityStatusCode;
    public String securityStatusPartyCode;
    public String securityStatusIssuer;
    public LocalDateTime securityStatusDateTime; // only apply when code is AIA

    public List<SecurityStatusDetailedInformation> securityStatusDetailedInformation;
    public List<SecurityTextualStatementInformation> securityTextualStatementInformation;
}
