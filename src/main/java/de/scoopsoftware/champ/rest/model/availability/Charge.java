package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.Objects;

public class Charge {

    private @Valid String code;
    private @Valid String description;
    private @Valid Float amount;

    @Schema(description = "Charge code", example = "FF")
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Charge code(String code) {
        setCode(code);
        return this;
    }


    @Schema(description = "Charge description", example = "CARGO SURCHARGE")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Charge description(String description) {
        setDescription(description);
        return this;
    }

    @Schema(description = "Charge amount", example = "31.49")
    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Charge amount(Float amount) {
        setAmount(amount);
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
        Charge charge = (Charge) o;
        return Objects.equals(this.amount, charge.amount) &&
                Objects.equals(this.code, charge.code) &&
                Objects.equals(this.description, charge.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, amount);
    }

    @Override
    public String toString() {

        return "class Charge {\n" +
                "    code: " + toIndentedString(code) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
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