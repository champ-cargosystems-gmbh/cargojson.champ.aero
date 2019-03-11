package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Shipment reference information.")
public class ShipmentReferenceInfo {

    @JsonPropertyDescription("Reference number allocated to a consignment as per shipper/agent/issuing carrier agreement.")
    @JsonDocExample("ABCD-12345")
    public Optional<String> referenceNumber = Optional.empty();

    @JsonPropertyDescription("Additional shipment information that supplements the reference number.")
    @JsonDocExample("COMPANY MAT")
    public Optional<String> info = Optional.empty();
}
