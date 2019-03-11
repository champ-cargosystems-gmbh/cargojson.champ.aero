package aero.champ.cargojson.consolidation;

import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.OCI;
import aero.champ.cargojson.common.SpecialHandlingAndDangerousGoodsCode;
import aero.champ.cargojson.common.Weight;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("House waybill summary details.")
public class HouseWaybillSummary {

    @JsonProperty(required = true)
    @JsonPropertyDescription("A serial number allocated by an agent/consolidator to identify a particular " +
            "air cargo shipment within a master air waybill.")
    @JsonDocExample("12345678ABCD")
    public String serialNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    public IATAAirportCode destination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs as accepted for carriage.")
    @JsonDocExample("8")
    public int numberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight of the cargo.")
    public Weight weight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Description of the goods for manifest purposes.")
    @JsonDocExample("Television sets")
    public String natureOfGoods;

    @JsonPropertyDescription("Shipper's load and count.")
    @JsonDocExample("15000")
    public Optional<Integer> shippersLoadAndCount = Optional.empty();

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods.")
    public Set<SpecialHandlingAndDangerousGoodsCode> specialHandlingRequirementsCodes = new HashSet<>();

    @JsonPropertyDescription("Free Text description of goods.")
    @JsonDocExample("3D 4K supersonic television sets.")
    public Optional<String> freeTextDescriptionOfGoods = Optional.empty();

    @JsonPropertyDescription("Harmonised tariff schedule information: Number identifying goods for customs or statistical purposes.")
    @JsonDocExample("427127829")
    public List<String> harmonisedTariffScheduleInformation = new ArrayList<>();

    @JsonPropertyDescription("Array of other customs, security and regulatory control information.")
    public List<OCI> oci = new ArrayList<>();

}
