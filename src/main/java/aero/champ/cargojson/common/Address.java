package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Postal address of an individual or a company.")
@Schema(description = "Postal address of an individual or a company.")
public class Address {

    @JsonProperty(required = true)
    @JsonPropertyDescription("First and mandatory name field.")
    @Schema(description = "First and mandatory name field.", example = "Donald Trump")
    public String name1;

    @JsonPropertyDescription("Optional second name field.")
    @Schema(description = "Optional second name field.", example = "President of the United States of America")
    public Optional<String> name2 = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("First and mandatory street field.")
    @Schema(description = "First and mandatory street field.", example = "The White House")
    public String streetAddress1;

    @JsonPropertyDescription("Optional second street field.")
    @Schema(description = "Optional second street field.", example = "1600 Pennsylvania Avenue NW")
    public Optional<String> streetAddress2 = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location or place of the address.")
    @Schema(description = "Location or place of the address.", example = "Washington, DC")
    public String place;

    @JsonPropertyDescription("Part of a country.")
    @Schema(description = "Part of a country.", example = "DC")
    public Optional<String> stateProvince = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO Country Code of the address.")
    @Schema(description = "ISO Country Code of the address.")
    public ISOCountryCode country;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Postal code of the address.")
    @Schema(description = "Postal code of the address.", example = "20500")
    public String postCode;

}
