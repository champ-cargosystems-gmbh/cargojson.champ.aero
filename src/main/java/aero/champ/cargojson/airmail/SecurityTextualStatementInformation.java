package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SecurityTextualStatementInformation {
    @JsonProperty(required = true)
    public List<String> consSecurityStatusLine;
}
