package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Postal address of an individual or a company.")
public class Address {

    @XmlAttribute
    @JsonProperty(required = true)
    @JsonPropertyDescription("First and mandatory name field.")
    @JsonDocExample("Donald Trump")
    public String name1;

    @JsonPropertyDescription("Optional second name field.")
    @JsonDocExample("President of the United States of America")
    public Optional<String> name2 = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("First and mandatory street field.")
    @JsonDocExample("The White House")
    public String streetAddress1;

    @JsonPropertyDescription("Optional second street field.")
    @JsonDocExample("1600 Pennsylvania Avenue NW")
    public Optional<String> streetAddress2 = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location or place of the address.")
    @JsonDocExample("Washington, DC")
    public String place;

    @JsonPropertyDescription("Part of a country.")
    @JsonDocExample("DC")
    public Optional<String> stateProvince = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO Country Code of the address.")
    public ISOCountryCode country;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Postal code of the address.")
    @JsonDocExample("20500")
    public String postCode;

}
