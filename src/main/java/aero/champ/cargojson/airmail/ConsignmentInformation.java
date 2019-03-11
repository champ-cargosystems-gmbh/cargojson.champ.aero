package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;


public class ConsignmentInformation {

    @JsonProperty(required = true)
    public String consignmentDocumentNumber;                    // BGM
    @JsonProperty(required = true)
    public String messageFunctionCode;
    @JsonProperty(required = true)
    public String consignmentCategory;                          // FTX
    @JsonProperty(required = true)
    public LocalDateTime consignmentCompletionDateTime;        // DTM

    public String consignmentShipper;                           // RFF
    public String consignmentAddressee;                           // RFF
    public String consignmentContract;                          // RFF
    public String consignmentBillingCarrier;                    // TDT
    public String consignmentPawbNumber;                        // RFF
    public String consignmentOrigin;                            // RFF ?
    public String consignmentDestination;                       // RFF
    public String consignmentPartyToBeInvoiced;                 // RFF
    public String consignmentRouteId;
}
