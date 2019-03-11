package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Message header for Edifact data.")
public class EdifactMessageHeader {

    @JsonPropertyDescription("Common access reference: Reference serving as a key to relate all subsequent " +
            "transfers of data to the same business case or file.")
    @JsonDocExample("10381")
    public Optional<String> commonAccessReference = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Message reference number assigned by the message sender.")
    @JsonDocExample("ORDERS:D:94B:UN")
    public String messageReference;

    @JsonPropertyDescription("Recipient's reference password.")
    @JsonDocExample("test1234")
    public Optional<String> password = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Uniquely identifying the interchange. Created by the interchange sender.")
    @JsonDocExample("abcde1234567")
    public String interchangeControlReference;

}
