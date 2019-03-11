package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("General multi-purpose reference information.")
public class ReferenceInfo {

    @JsonPropertyDescription("Office message address.")
    public Optional<OfficeMessageAddress> officeMessageAddress = Optional.empty();

    @JsonPropertyDescription("File reference: A reference used to identify a specific booking or file.")
    @JsonDocExample("123456")
    public Optional<String> fileReference = Optional.empty();

    @JsonPropertyDescription("Participant identification ")
    public Optional<ParticipantIdentifier> participantIdentifier = Optional.empty();
}
