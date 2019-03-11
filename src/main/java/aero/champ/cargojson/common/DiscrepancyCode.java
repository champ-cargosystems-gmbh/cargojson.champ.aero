package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Optional;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Coded representation of a discrepancy.")
public enum DiscrepancyCode {

    FOUND_AIR_WAYBILL("FDAW"),
    FOUND_CARGO("FDCA"),
    MISSING_AIR_WAYBILL("MSAW"),
    MISSING_CARGO("MSCA","CPEB"),
    FOUND_MAIL_DOCUMENT("FDAV"),
    FOUND_MAILBAG("FDMB"),
    MISSING_MAIL_DOCUMENT("MSAV"),
    MISSING_MAILBAG("MSMB"),
    DEFINITELY_LOADED("DFLD"),
    OFFLOADED("OFLD"),
    OVERCARRIED("OVCD"),
    SHORTSHIPPED("SSPD");

    public final String cargoImpCode;
    public final Optional<String> alternateCode;
    DiscrepancyCode(String cargoImpCode) {
        this.cargoImpCode = cargoImpCode;
        this.alternateCode = Optional.empty();
    }

    DiscrepancyCode(String cargoImpCode, String alternateCode) {
        this.cargoImpCode = cargoImpCode;
        this.alternateCode = Optional.of(alternateCode);
    }

    public static DiscrepancyCode fromCargoImpCode(String cargoImpCode) {
        for (DiscrepancyCode code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return code;
        }
        throw new IllegalArgumentException("No such cargo imp code: '"+cargoImpCode+"'");
    }

    public static Optional<DiscrepancyCode> optFromCargoImpCode(String cargoImpCode) {
        for (DiscrepancyCode code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return Optional.of(code);
            if (code.alternateCode.map(c->c.equals(cargoImpCode)).orElse(false)) {
                return Optional.of(code);
            }
        }
        return Optional.empty();
    }

}
