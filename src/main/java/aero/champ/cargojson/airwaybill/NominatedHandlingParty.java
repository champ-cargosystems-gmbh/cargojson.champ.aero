package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Nominated handling party.")
public class NominatedHandlingParty {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Identification of individual or company involved in the movement of a consignment.")
    @JsonDocExample("ACE Shipping Co.")
    public final String name;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location of individual or company involved in the movement of a consignment.")
    @JsonDocExample("London")
    public final String place;

    @JsonCreator
    public NominatedHandlingParty(@JsonProperty(required = true,value = "name")
            String name,
            @JsonProperty(required = true,value = "place")
            String place) {
        this.name = name;
        this.place = place;
    }


}
