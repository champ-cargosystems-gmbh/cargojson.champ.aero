package aero.champ.cargojson.confirmationreceipt;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonDocHint(toplevel = true)
@JsonClassDescription("Cargo Canonical message containing a ConfirmationReceipt as payload.")
public class ConfirmationReceiptMessage extends Message<ConfirmationReceipt> {
}
