package aero.champ.cargojson.spaceallocation;

import aero.champ.cargojson.common.*;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Space Allocation Request is used for the following actions:\n" +
        "-- request that space on one or more flights be allocated for a nominated consignment." +
        "-- request that the space allocated for a nominated consignment on one or more flights be cancelled." +
        "-- request that the space allocated for a nominated consignment on one or more flights be cancelled and replaced by a similar space allocation on another flight(s)." +
        "-- add new information or to change/delete information to existing booking(s)."
)
public class SpaceAllocationRequest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin and destination airports of the consigment.")
    public OriginAndDestination originAndDestination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Quantity details of the consigment.")
    public Quantity quantity;

    @JsonPropertyDescription("Volume data of the consignment.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("Density group - usually given if no volume data is specified.")
    public Optional<DensityGroup> densityGroup = Optional.empty();

    @JsonPropertyDescription("Total number of pieces of complete consignment.")
    @JsonDocExample("20")
    public Optional<Integer> totalConsignmentPieces = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Short description of the nature of the contained goods.")
    @JsonDocExample("Electronic parts")
    public String natureOfGoods;

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods.")
    public Set<SpecialHandlingAndDangerousGoodsCode> specialHandlingRequirements = new HashSet<>();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of flight details for the regarded consignment.")
    public List<FlightDetails> flightDetails = new ArrayList<>();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Booking reference.")
    public ReferenceInfo bookingReference;

    @JsonPropertyDescription("Array of Unit Load Device (ULD) data.")
    public Optional<List<ULD>> uldDescriptions = Optional.empty();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @JsonDocExample("Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    @JsonPropertyDescription("Special Service Request (Information related to instructions for special action required).")
    @JsonDocExample("Must be kept above 5 degrees celsius.")
    public Optional<String> specialServiceRequest = Optional.empty();

    @JsonPropertyDescription("Array of dimensions information.")
    public Optional<List<DimensionInfo>> dimensionInformation = Optional.empty();

    @JsonPropertyDescription("Shipment reference information.")
    public Optional<ShipmentReferenceInfo> shipmentReferenceInformation = Optional.empty();

    @JsonPropertyDescription("Customer identification.")
    public Optional<CustomerIdentification> customerIdentification = Optional.empty();

    @JsonPropertyDescription("Product information.")
    public Optional<ProductInformation> productInformation = Optional.empty();

    @JsonPropertyDescription("Account contact of the shipper.")
    public Optional<AccountContact> shipper = Optional.empty();

    @JsonPropertyDescription("Account contact of the consignee.")
    public Optional<AccountContact> consignee = Optional.empty();

}
