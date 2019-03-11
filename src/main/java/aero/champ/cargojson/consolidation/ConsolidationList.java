package aero.champ.cargojson.consolidation;

import aero.champ.cargojson.airwaybill.ChargeDeclarations;
import aero.champ.cargojson.common.AccountContact;
import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A consolidation list is to provide a \"Check-list\" of House Waybills associated with a Master Air Waybill.")
public class ConsolidationList {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Origin and destination airports of the shipment.")
    public OriginAndDestination originAndDestination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Quantity details of the shipment.")
    public Quantity quantity;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of house waybill summary details.")
    public List<HouseWaybillSummary> houseWaybillSummaries = new ArrayList<>();

    @JsonPropertyDescription("Account contact of the shipper.")
    public Optional<AccountContact> shipper = Optional.empty();

    @JsonPropertyDescription("Account contact of the consignee.")
    public Optional<AccountContact> consignee = Optional.empty();

    @JsonPropertyDescription("Charge Declarations.")
    public Optional<ChargeDeclarations> chargeDeclarations = Optional.empty();
}
