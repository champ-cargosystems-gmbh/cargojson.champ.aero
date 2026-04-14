package aero.champ.cargojson.booking;

import aero.champ.cargojson.common.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

public class Customer {

    @JsonPropertyDescription("Account number: Coded identification of a participant.")
    @Schema(description = "Account number: Coded identification of a participant.", example = "ABC94269")
    @JsonProperty(required = true)
    public String accountNumber;

    @JsonPropertyDescription("IATA cargo agent numeric code Code issued by IATA to identify each IATA " +
            "cargo agent whose name is entered on the Cargo Agency List.")
    @Schema(description = "IATA cargo agent numeric code Code issued by IATA to identify each IATA " +
            "cargo agent whose name is entered on the Cargo Agency List.", example = "1234567")
    @JsonProperty(required = true)
    public String iataCargoAgentNumericCode;

    @JsonPropertyDescription("IATA cargo agent CASS address: Code issued by IATA to identify individual " +
            "agent locations for CASS billing purposes.")
    @Schema(description = "IATA cargo agent CASS address: Code issued by IATA to identify individual " +
            "agent locations for CASS billing purposes.", example = "1234")
    @JsonProperty(required = true)
    public String iataCargoAgentCASSAddress;

    //TBD
    public String officeNumber;

    //TBD
    public String requestingStation;

    //What is role code? May this be determined by system?

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO currency code: Coded representation of a currency approved by ISO.")
    @Schema(description = "ISO currency code: Coded representation of a currency approved by ISO.", example = "GBP")
    public String isoCurrencyCode;

    //omit: all units, assume metric system

    @JsonProperty(required = true)
    @JsonPropertyDescription("Address of the customer.")
    @Schema(description = "Address of the customer.")
    public Address address;

    public String emailAddress;
    public String phoneNumber;


}
