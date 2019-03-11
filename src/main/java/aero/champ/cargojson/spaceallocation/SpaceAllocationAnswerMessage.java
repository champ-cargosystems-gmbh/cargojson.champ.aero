package aero.champ.cargojson.spaceallocation;

import aero.champ.cargojson.common.Message;
import aero.champ.cargojson.docgen.annotations.JsonDocHint;
import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Cargo Canonical message containing a SpaceAllocationAnswer as payload.")
@JsonDocHint(toplevel = true)
public class SpaceAllocationAnswerMessage extends Message<SpaceAllocationAnswer> {
}
