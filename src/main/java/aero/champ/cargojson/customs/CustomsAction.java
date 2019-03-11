package aero.champ.cargojson.customs;

import aero.champ.cargojson.common.CustomsActionCode;
import aero.champ.cargojson.common.CustomsStatusCode;
import aero.champ.cargojson.common.OCI;
import aero.champ.cargojson.common.ParticipantCode;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomsAction {

    @JsonPropertyDescription("Optional information on the customs status code to facilitate interpretation.")
    public Optional<BriefStatus> briefStatus = Optional.empty();

    @JsonProperty(required = true)
    public CustomsStatusCode customsStatusCode;

    @JsonPropertyDescription("Information provided to, or received from, Customs.")
    @JsonProperty(required = true)
    public String notification;

    @JsonProperty(required = true)
    public CustomsActionCode customsActionCode;

    @JsonProperty(required = true)
    public LocalDateTime dateOfNotification;

    @JsonPropertyDescription("Number assigned to the Customs Entry by Customs.")
    @JsonDocExample("48622")
    @JsonProperty(required = true)
    @Pattern(regexp = "(?:[0-9A-Z]{1,35})")
    public String customsEntryNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Actioned number of pieces.")
    @JsonDocExample("20")
    public BigInteger actionedNumberOfPieces;

    @JsonPropertyDescription("Coded identification of the warehouse where a bonded shipment will be stored.")
    @JsonDocExample("96763")
    @Pattern(regexp = "(?:[0-9A-Z]{1,7})")
    public Optional<String> bondedPremisesIdentification = Optional.empty();


    @JsonPropertyDescription("Identification of individual or company involved in the movement of a consignment.")
    @JsonDocExample("ACE SHIPPING CO")
    public Optional<String> nameOfNominatedAgentOrConsignee = Optional.empty();


    @JsonPropertyDescription("Coded identification of a participant involved in the movement of a shipment.")
    @Pattern(regexp = "(?:.{1,17})")
    @JsonDocExample("96764")
    public Optional<ParticipantCode> participantCodeOfNominatedAgentOrConsignee = Optional.empty();

    @JsonPropertyDescription("Other customs, security and regulatory information.")
    public Optional<List<OCI>> oci = Optional.empty();


}
