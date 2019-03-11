package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ReceivingDeclarationDetails {
    @JsonProperty(required = true)
    public String receivingPartyDeclarationSignature;
    @JsonProperty(required = true)
    public PartyDeclaration partyDeclaration = new PartyDeclaration();
}
