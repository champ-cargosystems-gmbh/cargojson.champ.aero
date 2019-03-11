package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Prepaid/Collect indicator: Code indicating whether payment will be made at origin (prepaid) or at destination (collect).")
public enum PaymentCondition {
    Collect("C"), Prepaid("P");

    public final String cargoImpCode;

    PaymentCondition(String code) { this.cargoImpCode = code; }

    public static PaymentCondition fromCargoImpCode(String code) {
        return Collect.cargoImpCode.equals(code) ? Collect : Prepaid.cargoImpCode.equals(code) ? Prepaid : null;
    }
}
