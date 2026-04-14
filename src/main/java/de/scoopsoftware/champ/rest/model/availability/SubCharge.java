package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubCharge {
    private @Valid String type;
    private @Valid Float totalAmount;
    private @Valid List<Charge> charges = new ArrayList<>();

    @Schema(description = "Charges type", example = "surCharges")
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubCharge type(String type) {
        setType(type);
        return this;
    }

    @Schema(description = "Total amount", example = "31.49")
    @JsonProperty("totalAmount")
    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public SubCharge totalAmount(Float totalAmount) {
        setTotalAmount(totalAmount);
        return this;
    }

    @Schema(description = "Charges")
    @JsonProperty("charges")
    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public SubCharge charges(List<Charge> charges) {
        setCharges(charges);
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
        SubCharge subCharge = (SubCharge) o;
        return Objects.equals(this.type, subCharge.type) &&
                Objects.equals(this.totalAmount, subCharge.totalAmount) &&
                Objects.equals(this.charges, subCharge.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, totalAmount, charges);
    }

    @Override
    public String toString() {

        return "class SubCharge {\n" +
                "    type: " + toIndentedString(type) + "\n" +
                "    totalAmount: " + toIndentedString(totalAmount) + "\n" +
                "    charges: " + toIndentedString(charges) + "\n" +
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