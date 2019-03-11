package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Addressing data of a Cargo Canonical Message.")
public class Addressing {

    @JsonPropertyDescription("Participant address the message shall be sent via.")
    public Optional<ParticipantAddress> routeVia = Optional.empty();

    @JsonPropertyDescription("Participant address an answer to the message shall be sent via.")
    public Optional<ParticipantAddress> routeAnswerVia = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of addresses of the sender of the message.")
    public List<ParticipantAddress> senderAddresses = new ArrayList<>();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of addresses of the final recipients.")
    public List<ParticipantAddress> finalRecipientAddresses = new ArrayList<>();

    @JsonPropertyDescription("Array of addresses that shall be used to deliver replies to the message.")
    public List<ParticipantAddress> replyAnswerTo = new ArrayList<>();

}
