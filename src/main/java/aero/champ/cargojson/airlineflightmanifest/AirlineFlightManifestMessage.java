package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Cargo Canonical message containing an Airline Flight Manifest as payload.")
@Schema(description = "Cargo Canonical message containing an Airline Flight Manifest as payload.")
@JsonDocHint(toplevel = true)
public class AirlineFlightManifestMessage extends Message<AirlineFlightManifest> {
}
