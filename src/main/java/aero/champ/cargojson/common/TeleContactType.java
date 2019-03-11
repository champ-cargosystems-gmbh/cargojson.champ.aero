package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TeleContactType {

    TELEPHONE,
    TELEFAX,
    TELEX,
    EMAIL,
    ;

}
