package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.*;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("An air waybill (AWB) is a receipt issued by an international airline for goods and an evidence of the contract of carriage.")
@Schema(description = "An air waybill (AWB) is a receipt issued by an international airline for goods and an evidence of the contract of carriage.")
public class AirWayBill {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    @Schema(description = "Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    @Schema(description = "Airport code of origin airport.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    @Schema(description = "Airport code of destination airport.")
    public IATAAirportCode destination;

    //omit shipment description code as its appearance in cargo imp simply forces you to specify "T" without any extra information
    @JsonProperty(required = true)
    @JsonPropertyDescription("Total number of pieces of complete consignment.")
    @Schema(description = "Total number of pieces of complete consignment.", example = "20")
    public int totalConsignmentNumberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight data of the consignment.")
    @Schema(description = "Weight data of the consignment.")
    public Weight weight;

    @JsonPropertyDescription("Volume data of the consignment.")
    @Schema(description = "Volume data of the consignment.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("Density group - usually given if no volume data is specified.")
    @Schema(description = "Density group - usually given if no volume data is specified.")
    public Optional<DensityGroup> densityGroup = Optional.empty();

    @JsonPropertyDescription("Flight bookings.")
    @Schema(description = "Flight bookings.")
    public Optional<List<Flight>> flights = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Routing.")
    @Schema(description = "Routing.")
    public List<Routing> route = new ArrayList<>();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Account contact of the shipper.")
    @Schema(description = "Account contact of the shipper.")
    public AccountContact shipper;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Account contact of the consignee.")
    @Schema(description = "Account contact of the consignee.")
    public AccountContact consignee;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Carrier's execution.")
    @Schema(description = "Carrier's execution.")
    public CarriersExecution carriersExecution;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Sender reference.")
    @Schema(description = "Sender reference.")
    public ReferenceInfo senderReference;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Charge Declarations.")
    @Schema(description = "Charge Declarations.")
    public ChargeDeclarations chargeDeclarations;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of charge items (also known as rate description).")
    @Schema(description = "Array of charge items (also known as rate description).")
    public List<ChargeItem> chargeItems = new ArrayList<>();

    @JsonPropertyDescription("Agent (if Agent entitled to Commission).")
    @Schema(description = "Agent (if Agent entitled to Commission).")
    public Optional<AgentIdentification> agent = Optional.empty();

    @JsonPropertyDescription("Special Service Request (Information related to instructions for special action required).")
    @Schema(description = "Special Service Request (Information related to instructions for special action required).", example = "Must be kept above 5 degrees celsius.")
    public Optional<String> specialServiceRequest = Optional.empty();

    @JsonPropertyDescription("Account contact to be notified about shipment status changes.")
    @Schema(description = "Account contact to be notified about shipment status changes.")
    public Optional<AccountContact> alsoNotify = Optional.empty();

    @JsonPropertyDescription("Prepaid charge summary. Though optional, one of prepaid or collect charge summary must be given.")
    @Schema(description = "Prepaid charge summary. Though optional, one of prepaid or collect charge summary must be given.")
    public Optional<ChargeSummary> prepaidChargeSummary = Optional.empty();

    @JsonPropertyDescription("Collect charge summary. Though optional, one of prepaid or collect charge summary must be given.")
    @Schema(description = "Collect charge summary. Though optional, one of prepaid or collect charge summary must be given.")
    public Optional<ChargeSummary> collectChargeSummary = Optional.empty();

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods.")
    @Schema(description = "Array of codes for special handling and dangerous goods.")
    public Set<SpecialHandlingAndDangerousGoodsCode> specialHandlingCodes = new HashSet<>();

    @JsonPropertyDescription("Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.")
    @Schema(description = "Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.", example = "FOO")
    public Set<String> additionalSpecialHandlingCodes = new HashSet<>();

    @JsonPropertyDescription("Accounting information.")
    @Schema(description = "Accounting information.")
    public List<Accounting> accounting = new ArrayList<>();

    @JsonPropertyDescription("Other charges.")
    @Schema(description = "Other charges.")
    public List<OtherChargeItem> otherCharges = new ArrayList<>();

    @JsonPropertyDescription("Certification of the shipper (name of signature).")
    @Schema(description = "Certification of the shipper (name of signature).", example = "K. Wilson")
    public Optional<String> shippersCertification = Optional.empty();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    @JsonPropertyDescription("Charges Collect in destination currency.")
    @Schema(description = "Charges Collect in destination currency.")
    public Optional<CollectChargesInDestinationCurrency> chargesCollectInDestCurrency = Optional.empty();

    @JsonPropertyDescription("Code indicating the origin of goods for Customs purposes.")
    @Schema(description = "Code indicating the origin of goods for Customs purposes.", example = "T2")
    public Optional<String> customsOriginCode = Optional.empty();

    @JsonPropertyDescription("Commission information.")
    @Schema(description = "Commission information.")
    public Optional<CommissionInfo> commissionInfo = Optional.empty();

    @JsonPropertyDescription("Sales incentive information.")
    @Schema(description = "Sales incentive information.")
    public Optional<SalesIncentive> salesIncentive = Optional.empty();

    @JsonPropertyDescription("Agent file reference used to identify a specific booking or file.")
    @Schema(description = "Agent file reference used to identify a specific booking or file.", example = "123456")
    public Optional<String> agentFileReference = Optional.empty();

    @JsonPropertyDescription("Nominated handling party.")
    @Schema(description = "Nominated handling party.")
    public Optional<NominatedHandlingParty> nominatedHandlingParty = Optional.empty();

    @JsonPropertyDescription("Shipment reference information.")
    @Schema(description = "Shipment reference information.")
    public Optional<ShipmentReferenceInfo> shipmentReferenceInformation = Optional.empty();

    @JsonPropertyDescription("Array of other participant information.")
    @Schema(description = "Array of other participant information.")
    public List<OtherParticipant> otherParticipant = new ArrayList<>();

    @JsonPropertyDescription("Array of other customs, security and regulatory control information.")
    @Schema(description = "Array of other customs, security and regulatory control information.")
    public List<OCI> oci = new ArrayList<>();

}
