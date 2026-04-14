package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;


public class Price {

    private @Valid Float amount;
    private @Valid Boolean allInRate;
    private @Valid Currency currency;
    private @Valid String type;
    private @Valid List<SubCharge> chargeBreakdown;

    @Schema(description = "Applicable shipment price.", example = "1205.5")
    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Price amount(Float amount) {
        this.amount = amount;
        return this;
    }

    @Schema(description = "Indicates whether the rate includes other charge amount or not.", example = "true")
    @JsonProperty("allInRate")
    public Boolean getAllInRate() {
        return allInRate;
    }

    public void setAllInRate(Boolean allInRate) {
        this.allInRate = allInRate;
    }

    public Price allInRate(Boolean allInRate) {
        this.allInRate = allInRate;
        return this;
    }

    @Schema()
    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Price currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Schema(description = "Cargospot identifier for the type of rate sheet applied. Possible values for a rate sheet will depend on the configuration in Cargospot.", example = "Contract")
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Price type(String type) {
        this.type = type;
        return this;
    }

    @Schema(description = "Charge breakdown")
    @JsonProperty("chargeBreakdown")
    public List<SubCharge> getChargeBreakdown() {
        return chargeBreakdown;
    }

    public void setChargeBreakdown(List<SubCharge> chargeBreakdown) {
        this.chargeBreakdown = chargeBreakdown;
    }

    public Price chargeBreakdown(List<SubCharge> chargeBreakdown) {
        setChargeBreakdown(chargeBreakdown);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return
                Objects.equals(this.amount, price.amount) &&
                        Objects.equals(this.allInRate, price.allInRate) &&
                        Objects.equals(this.currency, price.currency) &&
                        Objects.equals(this.type, price.type) &&
                        Objects.equals(this.chargeBreakdown, price.chargeBreakdown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, allInRate, currency, type);
    }

    @Override
    public String toString() {

        return "class Price {\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    allInRate: " + toIndentedString(allInRate) + "\n" +
                "    currency: " + toIndentedString(currency) + "\n" +
                "    type: " + toIndentedString(type) + "\n" +
                "    chargeBreakdown: " + toIndentedString(chargeBreakdown) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}