package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Participant identification.")
@Schema(description = "Participant identification.")
public class ParticipantIdentifier {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Type of participant involved in the movement of a shipment.")
    @Schema(description="Type of participant involved in the movement of a shipment.")
    public ParticipantType identifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Participant code: Coded identification of a participant involved in the movement of a shipment.")
    @Schema(description = "Participant code: Coded identification of a participant involved in the movement of a shipment.", example = "98764")
    public String code;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Coded representation of a specific airport/city code.")
    @Schema(description = "Coded representation of a specific airport/city code.", example = "LHR")
    public String airportCityCode;
}
