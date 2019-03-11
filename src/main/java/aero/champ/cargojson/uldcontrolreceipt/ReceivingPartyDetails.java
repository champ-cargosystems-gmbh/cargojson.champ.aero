package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 11/30/2017.
 */
public class ReceivingPartyDetails {
    @JsonProperty(required = true)
    public String partyTypeCode;
    public String receivingPartyAccountNumber;
    public String receivingPartyInternalId;
    public String agencyCoded;
    public String receivingPartyStandardId;
    public String receivingPartyCode;
    @JsonProperty(required = true)
    public String receivingPartyName;
    @JsonProperty(required = true)
    public ReceivingPartyAddress receivingPartyAddress = new ReceivingPartyAddress();

    public List<ReceivingPartyContactInformation> receivingPartyContactInformationList = new ArrayList<ReceivingPartyContactInformation>();

}
