package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Accounting information")
public class Accounting {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Accounting Information Identifier (code indicating a specific kind of accounting information).")
    @JsonDocExample("GovernmentBillOfLading")
    public AccountingInformationIdentifier identifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Detail of accounting information ")
    @JsonDocExample("Payment by certified cheque.")
    public String accountingInformation;
}
