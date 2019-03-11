package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration of codes indicating whether a shipment is a total, part or split consignment.")
public enum ShipmentDescriptionCode {

    DIVIDED_CONSIGNMENT("D")
    ,MULTI_SHIPMENTS("M")
    ,PART_CONSIGNMENT("P")
    ,SPLIT_CONSIGMENT("S")
    ,TOTAL_CONSIGNMENT("T");


    public final String cargoImpCode;

    ShipmentDescriptionCode(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static ShipmentDescriptionCode fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }

}
