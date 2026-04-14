package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

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
    @Schema(description="Array of codes for special handling and dangerous goods.")
    public List<SpecialHandlingAndDangerousGoodsCode> specialHandlingAndDangerousGoodsCodes = new ArrayList<>();

    @JsonPropertyDescription("Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.")
    @Schema(description = "Special handling codes that are not covered by the enumeration type of field 'specialHandlingCodes'.", example = "FOO")
    public Set<String> additionalSpecialHandlingCodes = new HashSet<>();

    public List<DimensionInfo> dimensionInformation = new ArrayList<>();
    public List<RoutingAndBooking> onwardRoutingAndBooking = new ArrayList<>();
    public Optional<MovementPriorityCode> movementPriority = Optional.empty();
    public List<String> otherServiceInformation = new ArrayList<>();
    public Optional<String> customsOriginCode = Optional.empty();
    public List<OCI> oci = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consignment that = (Consignment) o;
        return Objects.equals(airWaybillNumber, that.airWaybillNumber) && Objects.equals(originAndDestination, that.originAndDestination) && Objects.equals(quantity, that.quantity) && Objects.equals(totalNumberOfPieces, that.totalNumberOfPieces) && Objects.equals(volumeDetail, that.volumeDetail) && Objects.equals(densityGroup, that.densityGroup) && Objects.equals(totalConsignmentPieces, that.totalConsignmentPieces) && Objects.equals(manifestDescriptionOfGoods, that.manifestDescriptionOfGoods) && Objects.equals(specialHandlingAndDangerousGoodsCodes, that.specialHandlingAndDangerousGoodsCodes) && Objects.equals(additionalSpecialHandlingCodes, that.additionalSpecialHandlingCodes) && Objects.equals(dimensionInformation, that.dimensionInformation) && Objects.equals(onwardRoutingAndBooking, that.onwardRoutingAndBooking) && Objects.equals(movementPriority, that.movementPriority) && Objects.equals(otherServiceInformation, that.otherServiceInformation) && Objects.equals(customsOriginCode, that.customsOriginCode) && Objects.equals(oci, that.oci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airWaybillNumber, originAndDestination, quantity, totalNumberOfPieces, volumeDetail, densityGroup, totalConsignmentPieces, manifestDescriptionOfGoods, specialHandlingAndDangerousGoodsCodes, additionalSpecialHandlingCodes, dimensionInformation, onwardRoutingAndBooking, movementPriority, otherServiceInformation, customsOriginCode, oci);
    }
}
