package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Carrier's execution.")
public class CarriersExecution {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Date of Air waybill issue.")
    public LocalDate date;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location (like 'LONDON') or coded representation of a specific airport/city (like 'LHR').")
    @JsonDocExample("LONDON")
    public String placeOrAirportCityCode;

    @JsonPropertyDescription("Authorisation: Name of signatory.")
    @JsonDocExample("K. Wilson")
    public Optional<String> authorisationSignature = Optional.empty();
}
