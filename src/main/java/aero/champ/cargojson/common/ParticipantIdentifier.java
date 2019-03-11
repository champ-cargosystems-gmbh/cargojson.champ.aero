package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Participant identification.")
public class ParticipantIdentifier {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Type of participant involved in the movement of a shipment.")
    public ParticipantType identifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Participant code: Coded identification of a participant involved in the movement of a shipment.")
    @JsonDocExample("98764")
    public String code;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Coded representation of a specific airport/city code.")
    @JsonDocExample("LHR")
    public String airportCityCode;
}
