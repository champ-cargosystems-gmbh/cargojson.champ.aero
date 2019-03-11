package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TypeOfTimeIndicator {

    ACTUAL("A"),
    ESTIMATED("E"),
    SCHEDULED("S"),
    DLH_L("L"),
    DLH_D("D"),
    DLH_T("T"),
    DLH_N("N");

    public final String cargoImpCode;

    TypeOfTimeIndicator(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static TypeOfTimeIndicator fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }

}
