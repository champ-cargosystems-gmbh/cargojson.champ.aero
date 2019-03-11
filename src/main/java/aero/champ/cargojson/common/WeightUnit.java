package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration for weight units.")
public enum WeightUnit {

    KILOGRAM("K","KGM", BigDecimal.ONE),
    POUND("L","LBR", BigDecimal.valueOf(0.45359233).setScale(8,BigDecimal.ROUND_HALF_DOWN)),
    ;

    public final String cargoImpCode;
    public final String cargoFactCode;
    public final BigDecimal kilogramEquivalent;

    WeightUnit(String cargoImpCode, String cargoFactCode, BigDecimal kilogramEquivalent) {
        this.cargoImpCode = cargoImpCode;
        this.cargoFactCode = cargoFactCode;
        this.kilogramEquivalent = kilogramEquivalent;
    }

    public static WeightUnit fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }

}
