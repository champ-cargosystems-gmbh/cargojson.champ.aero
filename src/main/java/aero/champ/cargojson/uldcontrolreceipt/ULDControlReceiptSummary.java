package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 11/30/2017.
 */
public class ULDControlReceiptSummary {
    public int totalNumberOfLines;
    @JsonProperty(required = true)
    public int totalNumberOfULDs;
    public int totalNumberOfNets;
    public int totalNumberOfDoors;
    public int totalNumberOfStraps;
    public int totalNumberOfFittings;
    public int totalNumberOfShipments;
    public String supplementaryInformation;
    @JsonProperty(required = true)
    public TransferringDeclarationDetails transferringDeclarationDetails = new TransferringDeclarationDetails();
    @JsonProperty(required = true)
    public ReceivingDeclarationDetails receivingDeclarationDetails = new ReceivingDeclarationDetails();
}
