package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Cargo Canonical message containing an AirWayBill as payload.")
@Schema(description = "Cargo Canonical message containing an AirWayBill as payload.")
@JsonDocHint(toplevel = true)
public class AirWayBillMessage extends Message<AirWayBill> {
}
