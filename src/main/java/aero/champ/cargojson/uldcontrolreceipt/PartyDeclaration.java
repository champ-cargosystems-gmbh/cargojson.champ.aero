package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Created by Andy on 12/4/2017.
 */
public class PartyDeclaration {
    @JsonProperty(required = true)
    public LocalDateTime declarationDateAndTime;
    @JsonProperty(required = true)
    public String declarationPlace;
    @JsonProperty(required = true)
    public String declarationSignature;
}
