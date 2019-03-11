package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 11/30/2017.
 */
public class TransferringPartyDetails {
    @JsonProperty(required = true)
    public String partyTypeCode;
    public String transferringPartyAccountNumber;
    public String transferringPartyInternalId;
    public String agencyCoded;
    public String transferringPartyStandardId;
    public String transferringPartyCode;
    @JsonProperty(required = true)
    public String transferringPartyName;

    @JsonProperty(required = true)
    public TransferringPartyAddress transferringPartyAddress = new TransferringPartyAddress();

    public List<TransferringPartyContactInformation> transferringPartyContactInformationList = new ArrayList<TransferringPartyContactInformation>();
}
