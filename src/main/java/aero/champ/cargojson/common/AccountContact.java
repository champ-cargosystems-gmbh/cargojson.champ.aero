package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Contact data of an account (for example for a shipper or a consignee.")
@Schema(description = "Contact data of an account (for example for a shipper or a consignee.")
public class AccountContact {

    @JsonPropertyDescription("Account number (coded identification of a participant).")
    @Schema(description = "Account number (coded identification of a participant).", example = "ABC94269")
    public Optional<String> accountNumber = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Address of the contact.")
    @Schema(description = "Address of the contact.")
    public Address address;

    @JsonPropertyDescription("Further contact details.")
    @Schema(description = "Further contact details.")
    public Optional<List<ContactDetail>> contactDetails = Optional.empty();
}
