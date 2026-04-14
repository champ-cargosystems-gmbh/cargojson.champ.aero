package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Accounting information identifier enumeration. Code indicating a specific kind of accounting information.")
@Schema(description = "Accounting information identifier enumeration. Code indicating a specific kind of accounting information.")
public enum AccountingInformationIdentifier {
    CreditCardNumber("CRN"),
    CreditCardExpiryDate("CRD"),
    CreditCardIssuanceName("CRI"),
    GeneralInformation("GEN"),
    GovernmentBillOfLading("GBL"),
    MiscellaneousChargeOrder("MCO"),
    ModeOfSettlement("STL"),
    ReturnToOrigin("RET"),
    ShippersReferenceNumber("SRN");

    public final String cargoImpCode;

    AccountingInformationIdentifier(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
    }

    public static AccountingInformationIdentifier fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v -> v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }


}
