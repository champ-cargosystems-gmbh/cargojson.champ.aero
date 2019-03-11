package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.ISOCountryCode;
import aero.champ.cargojson.common.ServiceCode;
import aero.champ.cargojson.common.Weight;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charge item.")
public class ChargeItem {

    @JsonPropertyDescription("Number of pieces: Number of loose items and/or ULD's as accepted for carriage.")
    @JsonDocExample("8")
    public Optional<Integer> numberOfPieces = Optional.empty();

    @Pattern(regexp = "[A-Z]{3}")
    @JsonPropertyDescription("Rate combination point (RCP): Point over which sector rates are combined.\n" +
            "Pattern: uppercase three-letter code.")
    @JsonDocExample("PAR")
    public Optional<String> rateCombinationPointCityCode = Optional.empty();

    @JsonPropertyDescription("Array of commodity item numbers. A commodity item number is to identify a specific commodity.")
    @JsonDocExample("9017")
    public Optional<Set<String>> commodityItemNumber = Optional.empty();

    @JsonPropertyDescription("Chargeable gross weight.")
    public Optional<Weight> grossWeight = Optional.empty();

    @JsonPropertyDescription("Nature and quantity of goods.")
    @JsonDocExample("Tooth paste")
    public Optional<String> goodsDescription = Optional.empty();

    @JsonPropertyDescription("Toggles whether 'goodsDescription' is contained in the house waybill.")
    public boolean consolidation = false;

    @JsonPropertyDescription("Array of harmonised commodity codes. A harmonised commodity code is a number " +
            "identifying goods for customs or statistical purposes.")
    @JsonDocExample("427127829")
    public Optional<List<String>> harmonisedCommodityCode = Optional.empty();

    @JsonPropertyDescription("Country of origin of goods.")
    public Optional<ISOCountryCode> isoCountryCodeOfOriginOfGoods = Optional.empty();

    @JsonPropertyDescription("Array of packaging details.")
    public Optional<List<Packaging>> packaging = Optional.empty();

    @JsonPropertyDescription("Array of charge data.")
    public Optional<List<Charge>> charges = Optional.empty();

    @JsonPropertyDescription("Service code.")
    public Optional<ServiceCode> serviceCode = Optional.empty();


}
