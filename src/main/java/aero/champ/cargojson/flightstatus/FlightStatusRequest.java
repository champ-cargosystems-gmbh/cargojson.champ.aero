package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.FlightDetails;
import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A request for the current status of a nominated consignment.")
@Schema(description = "A request for the current status of a nominated consignment.")
public class FlightStatusRequest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    @Schema(description = "Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonPropertyDescription("Origin and destination airports of the consignment.")
    @Schema(description = "Origin and destination airports of the consignment.")
    public Optional<OriginAndDestination> originAndDestination = Optional.empty();

    @JsonPropertyDescription("Quantity details of the consignment.")
    @Schema(description = "Quantity details of the consignment.")
    public Optional<Quantity> quantity = Optional.empty();

    @JsonPropertyDescription("Description of the goods for manifest purposes.")
    @Schema(description = "Description of the goods for manifest purposes.", example = "Black hats and sunglasses.")
    public Optional<String> natureOfGoods = Optional.empty();

    @JsonPropertyDescription("Array of flight details for the regarded consignment.")
    @Schema(description = "Array of flight details for the regarded consignment.")
    public Optional<List<FlightDetails>> flightDetailsList = Optional.empty();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

}
