package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Measurement unit for dimension data.")
public enum LengthUnit {

    CENTIMETRE("CMT")
    ,DECIMETRE("DMT")
    ,FOOT("FOT")
    ,INCH("INH")
    ,METRE("MTR")
    ,MILLIMETRE("MMT")
    ,YARD("YRD");

    public final String cargoImpCode;

    LengthUnit(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static LengthUnit fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }
}
