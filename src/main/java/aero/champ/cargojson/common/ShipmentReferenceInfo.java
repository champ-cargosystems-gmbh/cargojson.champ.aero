package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Shipment reference information.")
@Schema(description = "Shipment reference information.")
public class ShipmentReferenceInfo {

    @JsonPropertyDescription("Reference number allocated to a consignment as per shipper/agent/issuing carrier agreement.")
    @Schema(description = "Reference number allocated to a consignment as per shipper/agent/issuing carrier agreement.", example = "ABCD-12345")
    public Optional<String> referenceNumber = Optional.empty();

    @JsonPropertyDescription("Additional shipment information that supplements the reference number.")
    @Schema(description = "Additional shipment information that supplements the reference number.", example = "COMPANY MAT")
    public Optional<String> info = Optional.empty();
}
