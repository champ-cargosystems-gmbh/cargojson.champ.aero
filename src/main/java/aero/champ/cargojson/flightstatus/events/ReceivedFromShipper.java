package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.DensityGroup;
import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.Volume;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was received from shipper or agent.\nConforms to CIMP FSU status 'RCS'.")
@Schema(description = "This event reports that the consignment was received from shipper or agent.\nConforms to CIMP FSU status 'RCS'.")
public class ReceivedFromShipper extends FlightEvent {
    public ReceivedFromShipper(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport where the consignment was received.")
    @Schema(description="Airport where the consignment was received.")
    public IATAAirportCode airportOfReceipt;

    @JsonPropertyDescription("Identification of individual or company that received the consignment.")
    @Schema(description = "Identification of individual or company that received the consignment.", example = "Ace Shipping Co.")
    public Optional<String> receivedFromName = Optional.empty();

    @JsonPropertyDescription("Volume of the received consignment.")
    @Schema(description="Volume of the received consignment.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("Density group of the received consignment.")
    @Schema(description="Density group of the received consignment.")
    public Optional<DensityGroup> densityGroup = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(airportOfReceipt);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }


}