package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 11/30/2017.
 */
public class ULDControlReceiptBody {
    @JsonProperty(required = true)
    public ULDNumberDetails numberDetail = new ULDNumberDetails();
    @JsonProperty(required = true)
    public ULDOrigin uldOrigin = new ULDOrigin();
    @JsonProperty(required = true)
    public ULDDestination uldDestination = new ULDDestination();
    @JsonProperty(required = true)
    public String loadedFlag;
    public String uldWeight;
    public String uldPieces;
    public List<ConsignmentDetails> consignmentDetailsList = new ArrayList<ConsignmentDetails>();
    public int numberOfNets;
    public int numberOfDoor;
    public int numberOfStrap;
    public int numberOfFittings;
    @JsonProperty(required = true)
    public String demurrageCode;
    @JsonProperty(required = true)
    public boolean damageFlag;
    @JsonProperty(required = true)
    public String serviceabilityCode;
    public String ODLNCode;
    public String ODLNDescription;
    public String damageDescription;
    public String remarks;
}
