package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.OfficeMessageAddress;
import aero.champ.cargojson.common.ParticipantIdentifier;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Other participant information.")
public class OtherParticipant {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Identification of individual or company involved in the movement of a consignment.")
    @JsonDocExample("ACE Shipping Co.")
    public String name;

    @JsonPropertyDescription("Other participant office message address.")
    public Optional<OfficeMessageAddress> officeMessageAddress = Optional.empty();

    @JsonPropertyDescription("Other participant office file reference.")
    @JsonDocExample("123456")
    public Optional<String> fileReference = Optional.empty();

    @JsonPropertyDescription("Other participant identification.")
    public Optional<ParticipantIdentifier> participantIdentification = Optional.empty();
}
