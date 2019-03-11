package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonClassDescription("Routing data. At least one of the fields must be set.")
public class Routing {

    @JsonPropertyDescription("Carrier code")
    public final Optional<IATACarrierCode> carrierCode;

    @JsonPropertyDescription("Destination (airport/city code)")
    public final Optional<IATAAirportCode> destination;

    @JsonCreator
    public Routing(@JsonProperty("carrierCode") Optional<IATACarrierCode> carrierCode,
                   @JsonProperty("destination") Optional<IATAAirportCode> destination) {
        this.carrierCode = carrierCode;
        this.destination = destination;
    }
}
