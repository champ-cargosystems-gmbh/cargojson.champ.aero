package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Created by Andy on 11/30/2017.
 */
public class ULDControlReceiptHeader {

    public ULDControlReceiptHeader(){};
    @JsonProperty(required = true)
    public String uldControlReceiptNumber;
    @JsonProperty(required = true)
    public LocalDateTime transferDateAndTime;

    @JsonProperty(required = true)
    public TransferLocation transferLocation = new TransferLocation();

    @JsonProperty(required = true)
    public TransferringPartyDetails transferringPartyDetails = new TransferringPartyDetails();

    @JsonProperty(required = true)
    public ReceivingPartyDetails receivingPartyDetails = new ReceivingPartyDetails();

    @JsonProperty(required = true)
    public String loadedFlag;
}
