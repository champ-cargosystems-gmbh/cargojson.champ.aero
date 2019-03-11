package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Agent {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Name of the agent")
    public String name;

    @JsonProperty(required = true)
    public String place;

    public Optional<String> accountNumber = Optional.empty();

    public Optional<String> iataCargoAgentNumericCode = Optional.empty();

    public Optional<String> iataCargoAgentCASSAddress = Optional.empty();

    public Optional<String> participantIdentifier = Optional.empty();

}
