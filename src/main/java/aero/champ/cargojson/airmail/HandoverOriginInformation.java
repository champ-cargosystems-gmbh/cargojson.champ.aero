package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class HandoverOriginInformation {
    public String handoverOriginLocationCode;
    public String codeListQualifier;
    public String handoverOriginLocationCodeSource;
    public String handoverOriginLocationName;
    @JsonProperty(required = true)
    public LocalDateTime handoverOriginCutOff;
    @JsonIgnore
    public int unknownProperty1;
    @JsonIgnore
    public int unknownProperty2;
}
