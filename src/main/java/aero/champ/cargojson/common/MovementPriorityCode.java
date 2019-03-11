package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration for movement priorities.")
public enum MovementPriorityCode {

    CONSIGNMENT_UNDER_BOND("B")
    ,EXPRESS_PARCEL_SHIPMENT("E")
    ,EXRESS_SHIPMENT("X")
    ,HIGH("H")
    ,LOW("L")
    ,SERVICE_SHIPMENT("S");
    ;

    public final String cargoImpCode;

    MovementPriorityCode(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static MovementPriorityCode fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }
}
