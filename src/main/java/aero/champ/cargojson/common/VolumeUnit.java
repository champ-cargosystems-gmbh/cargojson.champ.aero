package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration for volume units.")
public enum VolumeUnit {

    CUBIC_CENTIMETRE("CC","CMQ"),
    CUBIC_FOOT("CF","FTQ"),
    CUBIC_INCH("CI","INQ"),
    CUBIC_METRE("MC","MTQ"),
    ;

    public final String cargoImpCode;
    public final String cargoFactCode;

    VolumeUnit(String cargoImpCode, String cargoFactCode) {
        this.cargoImpCode = cargoImpCode;
        this.cargoFactCode = cargoFactCode;
    }

    public static VolumeUnit fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }
}
