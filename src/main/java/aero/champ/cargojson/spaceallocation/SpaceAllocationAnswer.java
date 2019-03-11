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
        "-- reply to an AWB Space Allocation Request Message indicating that requested space can or cannot be confirmed." +
        "-- reply to an AWB Space Allocation Request Message indicating that request is being processed and that further Space Allocation Answer message will follow." +
        "-- reply to an AWB Space Allocation Request Message confirming or refusing the accepted updates by showing the new space allocation details."
)
public class SpaceAllocationAnswer {

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

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @JsonDocExample("Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    @JsonPropertyDescription("Special Service Request (Information related to instructions for special action required).")
    @JsonDocExample("Must be kept above 5 degrees celsius.")
    public Optional<String> specialServiceRequest = Optional.empty();

    @JsonPropertyDescription("Shipment reference information.")
    public Optional<ShipmentReferenceInfo> shipmentReferenceInformation = Optional.empty();

}
