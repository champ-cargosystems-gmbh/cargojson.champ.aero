package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.OriginAndDestination;
import aero.champ.cargojson.common.Quantity;
import aero.champ.cargojson.flightstatus.events.OtherCustomsSecurityAndRegulatoryInformation;
import aero.champ.cargojson.truckingstatus.TruckingEvent;
import aero.champ.cargojson.validation.ValidationContext;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Split consignment: A split consignment describes one of potential many " +
        "consignments belonging to the same air waybill.")
public class SplitConsignment {

    @JsonPropertyDescription("Origin and destination airports of the consignment.")
    @Schema(description = "Origin and destination airports of the consignment.")
    public Optional<OriginAndDestination> originAndDestination = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Quantity details of the consignment.")
    @Schema(description = "Quantity details of the consignment.")
    public Quantity quantity;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total number of pieces of the consignment.")
    @Schema(description = "Total number of pieces of the consignment.", example = "20")
    public BigInteger totalNumberOfPieces;

    @JsonPropertyDescription("Array of flight events reported so far.")
    @Schema(description="Array of flight events reported so far.")
    public List<FlightEvent> events = new ArrayList<>();

    @JsonPropertyDescription("List of trucking events reported so far.")
    @Schema(description="List of trucking events reported so far.")
    public List<TruckingEvent> truckingEvents = new ArrayList<>();

    @JsonPropertyDescription("Other customs, security and regulatory information.")
    @Schema(description="Other customs, security and regulatory information.")
    public Optional<OtherCustomsSecurityAndRegulatoryInformation> otherCustomsSecurityAndRegulatoryInformation = Optional.empty();

    @JsonPropertyDescription("Other service information: Remarks relating to a shipment.")
    @Schema(description = "Other service information: Remarks relating to a shipment.", example = "Extra charge due to special handling requirements.")
    public Optional<String> otherServiceInformation = Optional.empty();

    public void validateCargoImp(ValidationContext validationContext) {
        validationContext.withContext("events").validate(ctx->{
            for (int i = 0; i < events.size(); ++i) {
                FlightEvent sd = events.get(i);
                validationContext.withContext(String.valueOf(i)).validate(sd::validateCargoImp);
            }
        });
    }
}
