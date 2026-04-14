package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.OfficeMessageAddress;
import aero.champ.cargojson.common.ParticipantIdentifier;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Other participant information.")
@Schema(description = "Other participant information.")
public class OtherParticipant {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Identification of individual or company involved in the movement of a consignment.")
    @Schema(description = "Identification of individual or company involved in the movement of a consignment.", example = "ACE Shipping Co.")
    public String name;

    @JsonPropertyDescription("Other participant office message address.")
    @Schema(description="Other participant office message address.")
    public Optional<OfficeMessageAddress> officeMessageAddress = Optional.empty();

    @JsonPropertyDescription("Other participant office file reference.")
    @Schema(description = "Other participant office file reference.", example = "123456")
    public Optional<String> fileReference = Optional.empty();

    @JsonPropertyDescription("Other participant identification.")
    @Schema(description="Other participant identification.")
    public Optional<ParticipantIdentifier> participantIdentification = Optional.empty();
}
