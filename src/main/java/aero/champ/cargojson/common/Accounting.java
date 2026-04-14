package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Accounting information")
@Schema(description = "Accounting information")
public class Accounting {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Accounting Information Identifier (code indicating a specific kind of accounting information).")
    @Schema(description = "Accounting Information Identifier (code indicating a specific kind of accounting information).", example = "GovernmentBillOfLading")
    public AccountingInformationIdentifier identifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Detail of accounting information ")
    @Schema(description = "Detail of accounting information ", example = "Payment by certified cheque.")
    public String accountingInformation;
}
