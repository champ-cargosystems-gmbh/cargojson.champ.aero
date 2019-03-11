package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("ULD Loading Indicator: Code indicating ULD height or loading limitation.")
public enum ULDLoadingIndicator {

    MAIN_DECK_LOADING_ONLY("M")
    ,NOSE_DOOR_LOADING_ONLY("N")
    ,ULD_HEIGHT_BELOW_160_CENTIMETRES("L")
    ,ULD_HEIGHT_BELOW_160_AND_244_CENTIMETRES("U")
    ,ULD_HEIGHT_ABOVE_244_CENTIMETRES("R");

    public final String cargoImpCode;
    ULDLoadingIndicator(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static ULDLoadingIndicator fromCargoImpCode(String cargoImpCode) {
        for (ULDLoadingIndicator code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return code;
        }
        throw new IllegalArgumentException("No such cargo imp code: '"+cargoImpCode+"'");
    }

}
