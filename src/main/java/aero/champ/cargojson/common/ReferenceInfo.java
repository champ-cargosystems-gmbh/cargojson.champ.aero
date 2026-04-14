package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("General multi-purpose reference information.")
@Schema(description = "General multi-purpose reference information.")
public class ReferenceInfo {

    @JsonPropertyDescription("Office message address.")
    @Schema(description="Office message address.")
    public Optional<OfficeMessageAddress> officeMessageAddress = Optional.empty();

    @JsonPropertyDescription("File reference: A reference used to identify a specific booking or file.")
    @Schema(description = "File reference: A reference used to identify a specific booking or file.", example = "123456")
    public Optional<String> fileReference = Optional.empty();

    @JsonPropertyDescription("Participant identification ")
    @Schema(description="Participant identification ")
    public Optional<ParticipantIdentifier> participantIdentifier = Optional.empty();
}
