package aero.champ.cargojson.consolidation;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Cargo Canonical message containing a ConsolidationList as payload.")
@JsonDocHint(toplevel = true)
public class ConsolidationListMessage extends Message<ConsolidationList> {
}
