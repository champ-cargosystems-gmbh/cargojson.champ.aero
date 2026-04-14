package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Customer identification.")
@Schema(description = "Customer identification.")
public class CustomerIdentification {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The name of the individual or company.")
    @Schema(description = "The name of the individual or company.", example = "Supersonic Shipping Co.")
    public String name;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location of individual or company.")
    @Schema(description = "Location of individual or company.", example = "London")
    public String place;

    @JsonPropertyDescription("Account number: Coded identification of a participant.")
    @Schema(description = "Account number: Coded identification of a participant.", example = "ABC94269")
    public Optional<String> accountNumber = Optional.empty();

    @JsonPropertyDescription("IATA cargo agent numeric code Code issued by IATA to identify each IATA " +
            "cargo agent whose name is entered on the Cargo Agency List.")
    @Schema(description = "IATA cargo agent numeric code Code issued by IATA to identify each IATA " +
            "cargo agent whose name is entered on the Cargo Agency List.", example = "1234567")
    public Optional<String> iataCargoAgentNumericCode = Optional.empty();

    @JsonPropertyDescription("IATA cargo agent CASS address: Code issued by IATA to identify individual " +
            "agent locations for CASS billing purposes.")
    @Schema(description = "IATA cargo agent CASS address: Code issued by IATA to identify individual " +
            "agent locations for CASS billing purposes.", example = "1234")
    public Optional<String> iataCargoAgentCASSAddress = Optional.empty();

    @JsonPropertyDescription("Participant identifier: Code identifying the type of participant involved in the movement of a shipment.")
    @Schema(description = "Participant identifier: Code identifying the type of participant involved in the movement of a shipment.", example = "CNE")
    public Optional<String> participantIdentifier = Optional.empty();

}
