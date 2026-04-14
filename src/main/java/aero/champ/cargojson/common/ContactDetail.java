package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Contact Details.")
@Schema(description = "Contact Details.")
public class ContactDetail {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Code identifying a means of contact for a participant.")
    @Schema(description = "Code identifying a means of contact for a participant.", example = "TE")
    public String contactIdentifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contact Number of a participant .")
    @Schema(description = "Contact Number of a participant .", example = "5148446311")
    public String contactNumber;
}
