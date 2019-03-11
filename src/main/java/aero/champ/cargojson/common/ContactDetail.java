package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Contact Details.")
public class ContactDetail {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Code identifying a means of contact for a participant.")
    @JsonDocExample("TE")
    public String contactIdentifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contact Number of a participant .")
    @JsonDocExample("5148446311")
    public String contactNumber;
}
