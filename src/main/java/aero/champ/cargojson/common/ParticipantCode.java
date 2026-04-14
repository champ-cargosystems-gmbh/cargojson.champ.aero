package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

public class ParticipantCode {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Type of participant involved in the movement of a shipment.")
    @Schema(description="Type of participant involved in the movement of a shipment.")
    public final ParticipantType type;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Participant code: Coded identification of a participant involved in the movement of a shipment.")
    @Schema(description = "Participant code: Coded identification of a participant involved in the movement of a shipment.", example = "98764")
    @Pattern(regexp = "(?:.{1,17})")
    public final String code;

    @JsonCreator
    public ParticipantCode(@JsonProperty("type") ParticipantType type, @JsonProperty("code") @Pattern(regexp = "(?:.{1,17})") String code) {
        this.type = type;
        this.code = code;
    }
}
