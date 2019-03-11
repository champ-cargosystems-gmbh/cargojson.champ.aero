package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Service code to identify cargo products.")
public enum ServiceCode {

    AIRPORT_TO_AIRPORT("A"),
    SERVICE_SHIPMENT("B"),
    COMPANY_MATERIAL("C"),
    DOOR_TO_DOOR_SERVICE("D"),
    AIRPORT_TO_DOOR("E"),
    FLIGHT_SPECIFIC("F"),
    DOOR_TO_AIRPORT("G"),
    COMPANY_MAIL("H"),
    DIPLOMATIC_MAIL("I"),
    PRIORITY_SERVICE("J"),
    UNDOCUMENTED_K("K"),
    UNDOCUMENTED_L("L"),
    UNDOCUMENTED_M("M"),
    UNDOCUMENTED_N("N"),
    UNDOCUMENTED_O("O"),
    SMALL_PACKAGE_SERVICE("P"),
    UNDOCUMENTED_Q("Q"),
    UNDOCUMENTED_R("R"),
    SUBSTITUTE_TRUCK("S"),
    CHARTER("T"),
    UNDOCUMENTED_U("U"),
    UNDOCUMENTED_V("V"),
    UNDOCUMENTED_W("W"),
    EXPRESS_SHIPMENTS("X"),
    UNDOCUMENTED_Y("Y"),
    UNDOCUMENTED_Z("Z"),
    ;

    public final String cargoImpCode;

    ServiceCode(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static ServiceCode fromCargoImpCode(String code) {
        for (ServiceCode c : values()) {
            if (c.cargoImpCode.equals(code))
                return c;
        }
        return null;
    }
}


