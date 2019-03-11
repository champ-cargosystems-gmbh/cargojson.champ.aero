package aero.champ.cargojson.consolidation;

import aero.champ.cargojson.airwaybill.*;
import aero.champ.cargojson.common.*;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HouseWaybill {

    @JsonProperty(required = true)
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    public IATAAirportCode destination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The house way bill serial number")
    @JsonDocExample("LON123456789")
    public String serialNumber;

    @JsonProperty(required = true)
    public int numberOfPieces;

    @JsonProperty(required = true)
    public Weight weight;

    public Optional<List<Flight>> flights = Optional.empty();

    public Optional<List<Routing>> route = Optional.empty();

    public Optional<AccountContact> shipper = Optional.empty();

    public Optional<AccountContact> consignee = Optional.empty();

    public Optional<AgentIdentification> agent = Optional.empty();

    @JsonDocExample("En close pouch with export documents")
    public Optional<String> specialServiceRequest = Optional.empty();

    public Optional<AccountContact> alsoNotify  = Optional.empty();

    public Optional<List<Accounting>> accounting = Optional.empty();

    @JsonProperty(required = true)
    public ChargeDeclarations chargeDeclarations;

    public Optional<List<ChargeItem>> chargeItems = Optional.empty();

    public Optional<List<OtherChargeItem>> otherCharges = Optional.empty();

    public Optional<ChargeSummary> prepaidChargeSummary = Optional.empty();

    public Optional<ChargeSummary> collectChargeSummary = Optional.empty();

    public Optional<String> shippersCertification = Optional.empty();

    @JsonProperty(required = true)
    public CarriersExecution carriersExecution;

    @JsonDocExample("not secured")
    public Optional<String> otherServiceInformation = Optional.empty();

    public Optional<String> customsOriginCode = Optional.empty();

    @JsonProperty(required = true)
    public AccountContact agentsHeadOffice;

    public Optional<String> letterOfCredit = Optional.empty();

    public Optional<List<OtherParticipant>> otherParticipant = Optional.empty();

    public Set<SpecialHandlingAndDangerousGoodsCode> specialHandlingCodes = new HashSet<>();

    @JsonPropertyDescription("Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.")
    @JsonDocExample("FOO")
    public Set<String> additionalSpecialHandlingCodes = new HashSet<>();

    @JsonPropertyDescription("Shipment reference information.")
    public Optional<ShipmentReferenceInfo> shipmentReferenceInformation = Optional.empty();

    public Optional<List<OCI>> oci = Optional.empty();

}
