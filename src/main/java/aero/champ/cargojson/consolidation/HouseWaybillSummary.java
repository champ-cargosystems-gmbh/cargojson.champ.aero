package aero.champ.cargojson.consolidation;

import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.OCI;
import aero.champ.cargojson.common.SpecialHandlingAndDangerousGoodsCode;
import aero.champ.cargojson.common.Weight;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("House waybill summary details.")
@Schema(description = "House waybill summary details.")
public class HouseWaybillSummary {

    @JsonProperty(required = true)
    @JsonPropertyDescription("A serial number allocated by an agent/consolidator to identify a particular " +
            "air cargo shipment within a master air waybill.")
    @Schema(description = "A serial number allocated by an agent/consolidator to identify a particular " +
            "air cargo shipment within a master air waybill.", example = "12345678ABCD")
    public String serialNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    @Schema(description="Airport code of origin airport.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    @Schema(description="Airport code of destination airport.")
    public IATAAirportCode destination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs as accepted for carriage.")
    @Schema(description = "Number of loose items and/or ULDs as accepted for carriage.", example = "8")
    public int numberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight of the cargo.")
    @Schema(description="Weight of the cargo.")
    public Weight weight;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Description of the goods for manifest purposes.")
    @Schema(description = "Description of the goods for manifest purposes.", example = "Television sets")
    public String natureOfGoods;

    @JsonPropertyDescription("Shipper's load and count.")
    @Schema(description = "Shipper's load and count.", example = "15000")
    public Optional<Integer> shippersLoadAndCount = Optional.empty();

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods.")
    @Schema(description="Array of codes for special handling and dangerous goods.")
    public Set<SpecialHandlingAndDangerousGoodsCode> specialHandlingRequirementsCodes = new HashSet<>();

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods that are not listed in official directories.")
    @Schema(description="Array of codes for special handling and dangerous goods that are not listed in official directories.")
    public Set<String> additionalSpecialHandlingRequirementsCodes = new HashSet<>();

    @JsonPropertyDescription("Free Text description of goods.")
    @Schema(description = "Free Text description of goods.", example = "3D 4K supersonic television sets.")
    public Optional<String> freeTextDescriptionOfGoods = Optional.empty();

    @JsonPropertyDescription("Harmonised tariff schedule information: Number identifying goods for customs or statistical purposes.")
    @Schema(description = "Harmonised tariff schedule information: Number identifying goods for customs or statistical purposes.", example = "427127829")
    public List<String> harmonisedTariffScheduleInformation = new ArrayList<>();

    @JsonPropertyDescription("Array of other customs, security and regulatory control information.")
    @Schema(description="Array of other customs, security and regulatory control information.")
    public List<OCI> oci = new ArrayList<>();

}
