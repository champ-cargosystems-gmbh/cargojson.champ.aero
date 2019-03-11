package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charges Collect in destination currency.")
public class CollectChargesInDestinationCurrency {

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO currency code of destination currency. Coded representation of a currency approved by ISO.")
    @JsonDocExample("GBP")
    public String isoCurrencyCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Currency conversion rate: The rate at which one specified currency is expressed in another specified currency.")
    @JsonDocExample("2.1512")
    public BigDecimal currencyConversionRateOfExchange;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Collect charges amount in destination currency.")
    @JsonDocExample("430.24")
    public BigDecimal chargesInDestinationCurrency;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Charges amount at destination.")
    @JsonDocExample("200.00")
    public BigDecimal chargesAtDestination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total collect charges amount.")
    @JsonDocExample("200.00")
    public BigDecimal totalCollectCharges;
}
