package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("CASS Indicator used in CASS messages.\n" +
        "This switch indicates whether commission or sales incentive applies, whether an AWB is used " +
        "as an invoice or service, cancelled or voided, whether a tax calculation is required, whether " +
        "an amount is original or revised and late reporting waybills.")
public enum CASSIndicator {

    AWB_AS_INVOICE("I")
    ,CANCEL_AWB("C")
    ,CHARGES_CORRECTION_ADIVCE("CC")
    ,DEBIT_OR_CREDIT_MEMORANDUM("DC")
    ,IDENTIFICATION("ID")
    ,LATE_REPORTING_WAYBILLS("L")
    ,NO_COMMISSION_OR_NEGATIVE_SALES_INCENTIVE("N")
    ,ORIGINAL_DATA("DL")
    ,REVISED_ADJUSTED_DATA("AD")
    ,SERVICE_AWB("S")
    ,TAX_CALCULATION_REQUIRED("T")
    ,VOID_AWB("V");

    public final String cargoImpCode;

    CASSIndicator(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static CASSIndicator fromCargoImpCode(String cargoImpCode) {
        for (CASSIndicator code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return code;
        }
        throw new IllegalArgumentException("No such cargo imp code: '"+cargoImpCode+"'");
    }


}
