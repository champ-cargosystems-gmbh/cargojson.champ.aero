package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Office message address.")
public class OfficeMessageAddress {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Coded representation of a specific airport/city code.")
    @JsonDocExample("LHR")
    public String airportCityCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Office function designator: Code identifying an office for addressing purposes.")
    @JsonDocExample("6F")
    public String officeFunctionDesignator;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Company designator: Code identifying a company for addressing purposes.")
    @JsonDocExample("XB")
    public String companyDesignator;
}
