package aero.champ.cargojson.confirmationreceipt;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.InterchangeType;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This type is used to acknowledge the receipt of a message in the case when an " +
        "automatic response is not immediately possible or an error has occurred. Corresponds to CIMP " +
        "message types FMA and FNA.")
public class ConfirmationReceipt {

    @JsonPropertyDescription("Interchange type of the original message.")
    public Optional<InterchangeType> referencedMessageType = Optional.empty();

    @JsonPropertyDescription("Air waybill number of the original message.")
    public Optional<AirWaybillNumber> airWaybillNumber = Optional.empty();

    @JsonPropertyDescription("Origin airport code of the original message.")
    public Optional<IATAAirportCode> origin = Optional.empty();

    @JsonPropertyDescription("Destination airport code of the original message.")
    public Optional<IATAAirportCode> destination = Optional.empty();

    @JsonPropertyDescription("Flag indicating if the original message was rejected with an error.")
    @JsonProperty(required = true)
    public boolean rejected = false;

    @JsonPropertyDescription("Message body of the confirmation receipt. This should be the reason for acknowledgement " +
            "or the reason for rejection or error.")
    @JsonDocExample("Invalid AWB number")
    public Optional<String> textMessage = Optional.empty();

    @JsonPropertyDescription("Content of the original message in its original message format.")
    @JsonDocExample("FSR\n" +
            "157-97631844")
    public Optional<String> referenceMessageContent = Optional.empty();

    @JsonIgnore
    public Optional<String> fnaEnrichmentCode = Optional.empty();

}
