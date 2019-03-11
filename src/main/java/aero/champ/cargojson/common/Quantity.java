package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Quantity details of a shipment.")
public class Quantity {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Shipment description code.")
    public final ShipmentDescriptionCode shipmentDescriptionCode;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Number of loose items and/or ULDs as accepted for carriage.")
    @JsonDocExample("8")
    public final BigInteger numberOfPieces;

    @JsonPropertyDescription("Weight of the cargo.")
    public final Optional<Weight> weight;

    @JsonCreator
    public Quantity(@JsonProperty(required = true, value = "shipmentDescriptionCode") ShipmentDescriptionCode shipmentDescriptionCode,
                    @JsonProperty(required = true, value = "numberOfPieces") BigInteger numberOfPieces,
                    @JsonProperty(value = "weight") Optional<Weight> weight) {
        this.shipmentDescriptionCode = Optional.ofNullable(shipmentDescriptionCode).orElse(ShipmentDescriptionCode.TOTAL_CONSIGNMENT);
        this.numberOfPieces = numberOfPieces;
        this.weight = Optional.ofNullable(weight).orElse(Optional.empty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity = (Quantity) o;

        if (shipmentDescriptionCode != quantity.shipmentDescriptionCode) return false;
        if (!numberOfPieces.equals(quantity.numberOfPieces)) return false;
        return weight.equals(quantity.weight);
    }

    @Override
    public int hashCode() {
        int result = shipmentDescriptionCode.hashCode();
        result = 31 * result + numberOfPieces.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }
}
