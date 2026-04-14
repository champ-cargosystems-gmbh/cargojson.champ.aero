package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Office message address.")
@Schema(description = "Office message address.")
public class OfficeMessageAddress {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Coded representation of a specific airport/city code.")
    @Schema(description = "Coded representation of a specific airport/city code.", example = "LHR")
    public String airportCityCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Office function designator: Code identifying an office for addressing purposes.")
    @Schema(description = "Office function designator: Code identifying an office for addressing purposes.", example = "6F")
    public String officeFunctionDesignator;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Company designator: Code identifying a company for addressing purposes.")
    @Schema(description = "Company designator: Code identifying a company for addressing purposes.", example = "XB")
    public String companyDesignator;
}
