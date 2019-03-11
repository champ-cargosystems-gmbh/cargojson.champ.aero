package aero.champ.cargojson.uldexchangecontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ULDDetails {
    @JsonProperty(required = true)
    public ULDIdentification uldIdentification;
    @JsonProperty(required = true)
    public LocalDateTime dateTimeOfTransfer;
    @JsonProperty(required = true)
    public ReceivingPartyDetails receivingPartyDetails;
    @JsonProperty(required = true)
    public String locationOfTransfer;
    @JsonProperty(required = true)
    public String uldControlReceiptNumber;
    @JsonProperty(required = true)
    public String locationOfFinalDestination;
    @JsonProperty(required = true)
    public ULDConditionDetails uldConditionDetails;
}
