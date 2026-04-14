package aero.champ.cargojson.airwaybill;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Charges Collect in destination currency.")
@Schema(description = "Charges Collect in destination currency.")
public class CollectChargesInDestinationCurrency {

    @JsonProperty(required = true)
    @JsonPropertyDescription("ISO currency code of destination currency. Coded representation of a currency approved by ISO.")
    @Schema(description = "ISO currency code of destination currency. Coded representation of a currency approved by ISO.", example = "GBP")
    public String isoCurrencyCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Currency conversion rate: The rate at which one specified currency is expressed in another specified currency.")
    @Schema(description = "Currency conversion rate: The rate at which one specified currency is expressed in another specified currency.", example = "2.1512")
    public BigDecimal currencyConversionRateOfExchange;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Collect charges amount in destination currency.")
    @Schema(description = "Collect charges amount in destination currency.", example = "430.24")
    public BigDecimal chargesInDestinationCurrency;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Charges amount at destination.")
    @Schema(description = "Charges amount at destination.", example = "200.00")
    public BigDecimal chargesAtDestination;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Total collect charges amount.")
    @Schema(description = "Total collect charges amount.", example = "200.00")
    public BigDecimal totalCollectCharges;
}
