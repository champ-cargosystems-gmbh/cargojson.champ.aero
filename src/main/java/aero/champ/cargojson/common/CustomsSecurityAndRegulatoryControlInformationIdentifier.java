package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Customs, security and regulatory control information identifier.")
public enum CustomsSecurityAndRegulatoryControlInformationIdentifier {

    ACCOUNT_CONSIGNOR("AC"),
    AUTHORISED_ECONOMIC_OPERATOR("E"),
    AUTOMATED_BROKER_INTERFACE("A"),
    CERTIFICATE_NUMBER("C"),
    DANGEROUS_GOODS("D"),
    EXEMPTION_LEGEND("L"),
    INVOICE_NUMBER("V"),
    ITEM_NUMBER("I"),
    FACILITIES_INFORMATION("F"),
    KNOWN_CONSIGNOR("KC"),
    MOVEMENT_REFERENCE_NUMBER("M"),
    PACKING_LIST_NUMBER("P"),
    REGULATED_AGENT("RA"),
    REGULATED_CARRIER("RC"),
    LICENSE_IDENTIFICATION("LI"),
    DECLARATION_IDENTIFICATION("DI"),
    SCREENING_METHOD("SM"),
    SECURITY_STATUS_DATE_AND_TIME("SD"),
    SECURITY_STATUS_NAME_OF_ISSUER("SN"),
    SECURITY_STATUS("SS"),
    SECURITY_TEXTUAL_STATEMENT("ST"),
    EXPIRY_DATE("ED"),
    SEAL_NUMBER("N"),
    SYSTEM_DOWNTIME_REFERENCE("S"),
    TRADER_IDENTIFICATION_NUMBER("T"),
    UNIQUE_CONSIGNMENT_REFERENCE_NUMBER("U"),
    CUSTOMS_SECURITY_BLOCK("CB"),
    CUSTOMS_SECURITY_HOLD_DO_NOT_LOAD("CD"),
    CUSTOMS_RELEASE_OK("CO"),
    CONTACT_PERSON("CP"),
    CONTACT_TELEPHONE_NUMBER("CT")
    ;

    public final String cargoImpCode;
    CustomsSecurityAndRegulatoryControlInformationIdentifier(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static CustomsSecurityAndRegulatoryControlInformationIdentifier fromCargoImpCode(String cargoImpCode) {
        for (CustomsSecurityAndRegulatoryControlInformationIdentifier code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return code;
        }
        throw new IllegalArgumentException("No such cargo imp code: '"+cargoImpCode+"'");
    }

    public static boolean exists(String cargoImpCode) {
        for (CustomsSecurityAndRegulatoryControlInformationIdentifier code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return true;
        }
        return false;
    }
}
