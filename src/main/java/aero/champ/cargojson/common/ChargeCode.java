package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Charge Code: Code identifying a method of payment of charges.")
public enum ChargeCode {

    ALL_CHARGES_COLLECT("CC")
    ,ALL_CHARGES_COLLECT_BY_CREDIT_CARD("CZ")
    ,ALL_CHARGES_COLLECT_BY_GBL("CG")
    ,ALL_CHARGES_PREPAID_CASH("PP")
    ,ALL_CHARGES_PREPAID_CREDIT("PX")
    ,ALL_CHARGES_PREPAID_BY_CREDIT_CARD("PZ")
    ,ALL_CHARGES_PREPAID_BY_GBL("PG")
    ,DESTINATION_COLLECT_CASH("CP")
    ,DESTINATION_COLLECT_CREDIT("CX")
    ,DESTINATION_COLLECT_BY_MCO("CM")
    ,NO_CHARGE("NC")
    ,NO_WEIGHT_CHARGE_OTHER_CHARGES_COLLECT("NT")
    ,NO_WEIGHT_CHARGE_OTHER_CHARGES_PREPAID_BY_CREDIT_CARD("NZ")
    ,NO_WEIGHT_CHARGE_OTHER_CHARGES_PREPAID_BY_GBL("NG")
    ,NO_WEIGHT_CHARGE_OTHER_CHARGES_PREPAID_CASH("NP")
    ,NO_WEIGHT_CHARGE_OTHER_CHARGES_PREPAID_CREDIT("NX")
    ,PARTIAL_COLLECT_CREDIT_PARTIAL_PREPAID_CASH("CA")
    ,PARTIAL_COLLECT_CREDIT_PARTIAL_PREPAID_CREDIT("CB")
    ,PARTIAL_COLLECT_CREDIT_CARD_PARTIAL_PREPAID_CASH("CE")
    ,PARTIAL_COLLECT_CREDIT_CARD_PARTIAL_PREPAID_CREDIT("CH")
    ,PARTIAL_PREPAID_CASH_PARTIAL_COLLECT_CASH("PC")
    ,PARTIAL_PREPAID_CREDIT_PARTIAL_COLLECT_CASH("PD")
    ,PARTIAL_PREPAID_CREDIT_CARD_PARTIAL_COLLECT_CASH("PE")
    ,PARTIAL_PREPAID_CREDIT_CARD_PARTIAL_COLLECT_CREDIT("PH")
    ,PARTIAL_PREPAID_CREDIT_CARD_PARTIAL_COLLECT_CREDIT_CARD("PF");

    public final String cargoImpCode;

    ChargeCode(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static ChargeCode fromCargoImpCode(String code) {
        for (ChargeCode c : values()) {
            if (c.cargoImpCode.equals(code))
                return c;
        }
        return null;
    }
}


