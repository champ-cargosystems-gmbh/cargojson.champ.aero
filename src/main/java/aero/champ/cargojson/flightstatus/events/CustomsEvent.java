package aero.champ.cargojson.flightstatus.events;


import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.OCI;
import aero.champ.cargojson.common.ParticipantCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This is a base event for all customs related events.")
@Schema(description = "This is a base event for all customs related events.")
public abstract class CustomsEvent extends FlightEvent {

    @JsonPropertyDescription("Customs status code.")
    @Schema(description="Customs status code.")
    public Optional<String> customsStatusCode = Optional.empty();

    @JsonPropertyDescription("Notification.")
    @Schema(description="Notification.")
    public Optional<String> notification = Optional.empty();

    @JsonPropertyDescription("Customs action code.")
    @Schema(description="Customs action code.")
    public Optional<String> customsActionCode = Optional.empty();

    @JsonPropertyDescription("Customs entry number.")
    @Schema(description="Customs entry number.")
    public Optional<String> customsEntryNumber = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.empty();
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }

    @JsonPropertyDescription("Coded identification of the warehouse where a bonded shipment will be stored.")
    @Schema(description = "Coded identification of the warehouse where a bonded shipment will be stored.", example = "96763")
    @Pattern(regexp = "(?:[0-9A-Z]{1,7})")
    public Optional<String> bondedPremisesIdentification = Optional.empty();


    @JsonPropertyDescription("Identification of individual or company involved in the movement of a consignment.")
    @Schema(description = "Identification of individual or company involved in the movement of a consignment.", example = "ACE SHIPPING CO")
    public Optional<String> nameOfNominatedAgentOrConsignee = Optional.empty();


    @JsonPropertyDescription("Coded identification of a participant involved in the movement of a shipment.")
    @Schema(description = "Coded identification of a participant involved in the movement of a shipment.", example = "96764")
    @Pattern(regexp = "(?:.{1,17})")
    public Optional<ParticipantCode> participantCodeOfNominatedAgentOrConsignee = Optional.empty();

    @JsonPropertyDescription("Other customs, security and regulatory information.")
    @Schema(description="Other customs, security and regulatory information.")
    public Optional<List<OCI>> oci = Optional.empty();


}

