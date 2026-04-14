package aero.champ.cargojson.truckingstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A Flight Status indicates a status in the movement of the nominated consignment.")
@Schema(description = "A Flight Status indicates a status in the movement of the nominated consignment.")
public class TruckingStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonPropertyDescription("processType : firstmile or lastmile")
    @Schema(description = "processType : firstmile or lastmile")
    public Optional<TruckingProcessType> processType = Optional.empty();

    @JsonPropertyDescription("Contains the air waybill number.")
    @Schema(description = "Contains the air waybill number.")
    public Optional<AirWaybillNumber> airWaybillNumber = Optional.empty();

    @JsonPropertyDescription("Origin and destination airports of the consignment.")
    @Schema(description = "Origin and destination airports of the consignment.")
    public Optional<OriginAndDestination> originAndDestination = Optional.empty();

    @JsonPropertyDescription("Alternate reference for this shipment if no AWB number available.")
    @Schema(description = "Alternate reference for this shipment if no AWB number available.")
    public Optional<String> truckingReferenceNumber = Optional.empty();

    @JsonPropertyDescription("Quantity details of the consignment.")
    @Schema(description = "Quantity details of the consignment.")
    public Optional<Quantity> quantity = Optional.empty();

    @JsonPropertyDescription("Total number of pieces of the consignment.")
    @Schema(description = "Total number of pieces of the consignment.", example = "20")
    public Optional<BigInteger> totalNumberOfPieces = Optional.empty();

    @JsonPropertyDescription("Array of trucking events related to the trucking status. Will often be only one event.")
    @Schema(description = "Array of trucking events related to the trucking status. Will often be only one event.")
    public List<TruckingEvent> events = new ArrayList<>();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    public Optional<String> to = Optional.empty();

    public Optional<String> from = Optional.empty();

    public Optional<String> signature = Optional.empty();
}
