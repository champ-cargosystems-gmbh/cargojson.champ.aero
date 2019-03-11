package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 11/30/2017.
 */
public class ReceivingPartyContactInformation {
    public String receivingPartyContactName;
    @JsonProperty(required = true)
    public ListOfContactNumbers listOfContactNumbers = new ListOfContactNumbers();
}
