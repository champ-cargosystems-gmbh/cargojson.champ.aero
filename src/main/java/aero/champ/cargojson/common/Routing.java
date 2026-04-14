package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import java.util.Optional;

@JsonClassDescription("Routing data. At least one of the fields must be set.")
@Schema(description = "Routing data. At least one of the fields must be set.")
public class Routing {

    @JsonPropertyDescription("Carrier code")
    @Schema(description="Carrier code")
    public final Optional<IATACarrierCode> carrierCode;

    @JsonPropertyDescription("Destination (airport/city code)")
    @Schema(description="Destination (airport/city code)")
    public final Optional<IATAAirportCode> destination;

    @JsonCreator
    public Routing(@JsonProperty("carrierCode") Optional<IATACarrierCode> carrierCode,
                   @JsonProperty("destination") Optional<IATAAirportCode> destination) {
        this.carrierCode = carrierCode;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routing routing = (Routing) o;
        return Objects.equals(carrierCode, routing.carrierCode) && Objects.equals(destination, routing.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrierCode, destination);
    }
}
