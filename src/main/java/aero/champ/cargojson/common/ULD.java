package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Pattern;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Unit Load Device (ULD).")
public class ULD {

    @JsonProperty(required = true)
    @Pattern(regexp = "[A-Z][A-Z0-9]{2}")
    @JsonPropertyDescription("Code identifying a standard Unit Load Device type.\n" +
            "Must match regular expression '[A-Z][A-Z0-9]{2}'.")
    @JsonDocExample("ASE")
    public String type;

    @JsonProperty(required = true)
    @Pattern(regexp = "[A-Z0-9][0-9]{3,4}")
    @JsonPropertyDescription("Serial number allocated to each Unit Load Device by its owner.\n" +
            "Must match regular expression '[A-Z0-9][0-9]{3,4}'.")
    @JsonDocExample("1234")
    public String serialNumber;

    @JsonProperty(required = true)
    @Pattern(regexp = "[A-Z0-9]{2}")
    @JsonPropertyDescription("Code to identify the owner of a Unit Load Device.\n" +
            "Must match regular expression '[A-Z0-9]{2}'.")
    @JsonDocExample("TW")
    public String ownerCode;

    @JsonPropertyDescription("ULD loading indicator.")
    public Optional<ULDLoadingIndicator> loadingIndicator = Optional.empty();

    @JsonPropertyDescription("Information related to a specific Unit Load Device")
    @JsonDocExample("Do not load via nose door.")
    public Optional<String> remarks = Optional.empty();

    @JsonPropertyDescription("Weight of the ULD contents.")
    public Optional<Weight> weightOfULDContents  = Optional.empty();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ULD uld = (ULD) o;

        if (!type.equals(uld.type)) return false;
        if (!serialNumber.equals(uld.serialNumber)) return false;
        if (!ownerCode.equals(uld.ownerCode)) return false;
        if (!loadingIndicator.equals(uld.loadingIndicator)) return false;
        if (!remarks.equals(uld.remarks)) return false;
        return weightOfULDContents.equals(uld.weightOfULDContents);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + serialNumber.hashCode();
        result = 31 * result + ownerCode.hashCode();
        result = 31 * result + loadingIndicator.hashCode();
        result = 31 * result + remarks.hashCode();
        result = 31 * result + weightOfULDContents.hashCode();
        return result;
    }
}
