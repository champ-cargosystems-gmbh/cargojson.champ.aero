package aero.champ.cargojson.customs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BriefStatus {

    Accepted,
    Error,
    Reported,
    Hold,
    Undefined
    ;

    @JsonValue
    public String getValue() {
        return name();
    }

    @JsonCreator
    public static BriefStatus create(String value) {
        if (value == null || value.isEmpty())
            return null;
        try {
            return BriefStatus.valueOf(value);
        } catch (IllegalArgumentException iae) {
            return Undefined;
        }
    }
}
