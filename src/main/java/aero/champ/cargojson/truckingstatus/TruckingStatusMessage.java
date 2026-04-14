package aero.champ.cargojson.truckingstatus;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Cargo Canonical message containing a TruckingStatus as payload.")
@Schema(description = "Cargo Canonical message containing a TruckingStatus as payload.")
@JsonDocHint(toplevel = true)
public class TruckingStatusMessage extends Message<TruckingStatus> {
}
