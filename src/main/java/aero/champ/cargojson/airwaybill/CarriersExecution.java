package aero.champ.cargojson.airwaybill;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Carrier's execution.")
@Schema(description = "Carrier's execution.")
public class CarriersExecution {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date of Air waybill issue.")
    @Schema(description = "Date of Air waybill issue.")
    public LocalDate date;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location (like 'LONDON') or coded representation of a specific airport/city (like 'LHR').")
    @Schema(description = "Location (like 'LONDON') or coded representation of a specific airport/city (like 'LHR').", example = "LONDON")
    public String placeOrAirportCityCode;

    @JsonPropertyDescription("Authorisation: Name of signatory.")
    @Schema(description = "Authorisation: Name of signatory.", example = "K. Wilson")
    public Optional<String> authorisationSignature = Optional.empty();
}
