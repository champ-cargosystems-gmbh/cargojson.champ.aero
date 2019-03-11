package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Identifies an agent.")
public class AgentIdentification {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Identification of individual or company.")
    @JsonDocExample("ACE SHIPPING CO.")
    public String name;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Location of individual or company")
    @JsonDocExample("LONDON")
    public String place;

    @JsonPropertyDescription("Coded identification of a participant.")
    @JsonDocExample("ABC94269")
    public Optional<String> accountNumber = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("IATA Cargo Agent Numeric Code (code issued by IATA to identify " +
            "each IATA Cargo Agent whose name is entered on the Cargo Agency List).")
    @JsonDocExample("1234567")
    public String iataCargoAgentNumericCode;

    @JsonPropertyDescription("IATA Cargo Agent CASS Address (" +
            "code issued by IATA to identify individual agent locations for CASS billing purposes).")
    @JsonDocExample("1234")
    public Optional<String> iataCargoAgentCASSAddress = Optional.empty();

    @JsonPropertyDescription("Participant Identifier: Code identifying the type of participant involved in the movement of a shipment.")
    @JsonDocExample("CNE")
    public Optional<String> participantIdentifier = Optional.empty();

}
