package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Customer identification.")
public class CustomerIdentification {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The name of the individual or company.")
    @JsonDocExample("Supersonic Shipping Co.")
    public String name;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location of individual or company.")
    @JsonDocExample("London")
    public String place;

    @JsonPropertyDescription("Account number: Coded identification of a participant.")
    @JsonDocExample("ABC94269")
    public Optional<String> accountNumber = Optional.empty();

    @JsonPropertyDescription("IATA cargo agent numeric code Code issued by IATA to identify each IATA " +
            "cargo agent whose name is entered on the Cargo Agency List.")
    @JsonDocExample("1234567")
    public Optional<String> iataCargoAgentNumericCode = Optional.empty();

    @JsonPropertyDescription("IATA cargo agent CASS address: Code issued by IATA to identify individual " +
            "agent locations for CASS billing purposes.")
    @JsonDocExample("1234")
    public Optional<String> iataCargoAgentCASSAddress = Optional.empty();

    @JsonPropertyDescription("Participant identifier: Code identifying the type of participant involved in the movement of a shipment.")
    @JsonDocExample("CNE")
    public Optional<String> participantIdentifier = Optional.empty();

}
