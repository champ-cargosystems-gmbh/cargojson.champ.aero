package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.*;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigInteger;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Consignment {

    @JsonProperty(required = true)
    public AirWaybillNumber airWaybillNumber;

    public Optional<OriginAndDestination> originAndDestination  = Optional.empty();

    @JsonProperty(required = true)
    public Quantity quantity;

    @JsonProperty(required = true)
    public BigInteger totalNumberOfPieces;

    public Optional<Volume> volumeDetail = Optional.empty();

    public Optional<DensityGroup> densityGroup = Optional.empty();

    public Optional<BigInteger> totalConsignmentPieces = Optional.empty();
    @JsonProperty(required = true)
    public String manifestDescriptionOfGoods;

    @JsonPropertyDescription("Array of codes for special handling and dangerous goods.")
    public List<SpecialHandlingAndDangerousGoodsCode> specialHandlingAndDangerousGoodsCodes = new ArrayList<>();

    @JsonPropertyDescription("Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.")
    @JsonDocExample("FOO")
    public Set<String> additionalSpecialHandlingCodes = new HashSet<>();

    public List<DimensionInfo> dimensionInformation = new ArrayList<>();
    public List<RoutingAndBooking> onwardRoutingAndBooking = new ArrayList<>();
    public Optional<MovementPriorityCode> movementPriority = Optional.empty();
    public List<String> otherServiceInformation = new ArrayList<>();
    public Optional<String> customsOriginCode = Optional.empty();
    public List<OCI> oci = new ArrayList<>();

}
