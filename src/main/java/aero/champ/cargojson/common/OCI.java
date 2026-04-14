package aero.champ.cargojson.common;

import aero.champ.cargojson.validation.CargoImpPatterns;
import aero.champ.cargojson.validation.ValidationContext;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;
import java.util.regex.Pattern;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Other Customs, security and regulatory control Information.")
@Schema(description = "Other Customs, security and regulatory control Information.")
public class OCI {

    public OCI(){}

    @JsonPropertyDescription("ISO Country Code.")
    @Schema(description="ISO Country Code.")
    public Optional<ISOCountryCode> isoCountryCode = Optional.empty();

    @JsonPropertyDescription("Information identifier.")
    @Schema(description="Information identifier.")
    public Optional<DataElementGroupIdentifier> informationIdentifier = Optional.empty();

    @JsonPropertyDescription("Customs, security and regulatory control information identifier.")
    @Schema(description="Customs, security and regulatory control information identifier.")
    public Optional<CustomsSecurityAndRegulatoryControlInformationIdentifier> controlInformation = Optional.empty();

    @JsonPropertyDescription("Customs, security and regulatory control information identifier not contained in IATA CIMP Spec.")
    @Schema(description = "Customs, security and regulatory control information identifier not contained in IATA CIMP Spec.", example = "D")
    public Optional<String> additionalControlInformation = Optional.empty();

    @JsonPropertyDescription("Supplementary information identifying a party or a location related to customs, security " +
            "and regulatory control reporting requirements.")
    @Schema(description = "Supplementary information identifying a party or a location related to customs, security " +
            "and regulatory control reporting requirements.", example = "BCBP123")
    public Optional<String> supplementaryControlInformation = Optional.empty();

    static final Pattern SUPPLEMENTARY_CONTROL_INFORMATION_PATTERN = CargoImpPatterns.toPattern("t[...35]");
    public void validateCargoImp(ValidationContext validationContext) {
        supplementaryControlInformation.ifPresent(i -> validationContext.checkPattern(i, SUPPLEMENTARY_CONTROL_INFORMATION_PATTERN, "supplementaryControlInformation"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OCI oci = (OCI) o;

        if (!isoCountryCode.equals(oci.isoCountryCode)) return false;
        if (!informationIdentifier.equals(oci.informationIdentifier)) return false;
        if (!controlInformation.equals(oci.controlInformation)) return false;
        return supplementaryControlInformation.equals(oci.supplementaryControlInformation);
    }

    @Override
    public int hashCode() {
        int result = isoCountryCode.hashCode();
        result = 31 * result + informationIdentifier.hashCode();
        result = 31 * result + controlInformation.hashCode();
        result = 31 * result + supplementaryControlInformation.hashCode();
        return result;
    }
}
