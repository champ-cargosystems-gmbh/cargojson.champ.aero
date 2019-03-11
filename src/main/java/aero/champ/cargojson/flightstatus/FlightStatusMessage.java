package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Cargo Canonical message containing a FlightStatus as payload.")
@JsonDocHint(toplevel = true)
public class FlightStatusMessage extends Message<FlightStatus> {
}
