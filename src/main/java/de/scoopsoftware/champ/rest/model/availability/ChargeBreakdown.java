package de.scoopsoftware.champ.rest.model.availability;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

public class ChargeBreakdown {
    private @Valid List<SubCharge> charges;


    @Schema()
    @JsonProperty("chargeBreakdown")
    public List<SubCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<SubCharge> charges) {
        this.charges = charges;
    }

    public ChargeBreakdown charges(List<SubCharge> charges) {
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
        ChargeBreakdown chargeBreakdown = (ChargeBreakdown) o;
        return Objects.equals(this.charges, chargeBreakdown.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charges);
    }

    @Override
    public String toString() {

        return "class ChargeBreakdown {\n" +
                "    ChargeBreakdown: " + toIndentedString(charges) + "\n" +
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