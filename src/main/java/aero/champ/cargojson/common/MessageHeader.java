package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Message header of a Cargo Canonical Message.")
@Schema(description = "Message header of a Cargo Canonical Message.")
public class MessageHeader {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Addressing data.")
    @Schema(description="Addressing data.")
    public Addressing addressing = new Addressing();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date and time of message creation.")
    @Schema(description="Date and time of message creation.")
    public LocalDateTime creationDate = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

    @JsonPropertyDescription("Edifact data.")
    @Schema(description="Edifact data.")
    public Optional<EdifactMessageHeader> edifactData = Optional.empty();


}
