package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration indicating approximate density of goods.")
public enum DensityGroup {

    KG60_PER_CUBICMETRE(5),
    KG90_PER_CUBICMETRE(2),
    KG120_PER_CUBICMETRE(3),
    KG160_PER_CUBICMETRE(0),
    KG220_PER_CUBICMETRE(4),
    KG250_PER_CUBICMETRE(6),
    KG300_PER_CUBICMETRE(1),
    KG400_PER_CUBICMETRE(8),
    KG600_PER_CUBICMETRE(9),
    KG950_PER_CUBICMETRE(10),
    ;

    public final int cargoImpCode;
    DensityGroup(int cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static DensityGroup fromCargoImp(int cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode == cargoImpCode).findFirst().get();
    }
}
