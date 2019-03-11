package aero.champ.cargojson.customs;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Cargo Canonical message containing a Customs Status Notification as payload.")
@JsonDocHint(toplevel = true)
public class CustomsStatusNotificationMessage extends Message<CustomsStatusNotification> {
}
