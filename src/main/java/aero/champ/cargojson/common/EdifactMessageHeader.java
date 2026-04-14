package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Message header for Edifact data.")
@Schema(description = "Message header for Edifact data.")
public class EdifactMessageHeader {

    @JsonPropertyDescription("Common access reference: Reference serving as a key to relate all subsequent " +
            "transfers of data to the same business case or file.")
    @Schema(description = "Common access reference: Reference serving as a key to relate all subsequent " +
            "transfers of data to the same business case or file.", example = "10381")
    public Optional<String> commonAccessReference = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Message reference number assigned by the message sender.")
    @Schema(description = "Message reference number assigned by the message sender.", example = "ORDERS:D:94B:UN")
    public String messageReference;

    @JsonPropertyDescription("Recipient's reference password.")
    @Schema(description = "Recipient's reference password.", example = "test1234")
    public Optional<String> password = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Uniquely identifying the interchange. Created by the interchange sender.")
    @Schema(description = "Uniquely identifying the interchange. Created by the interchange sender.", example = "abcde1234567")
    public String interchangeControlReference;

}
