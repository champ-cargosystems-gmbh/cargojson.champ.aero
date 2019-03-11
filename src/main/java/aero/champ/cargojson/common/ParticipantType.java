package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration for participant type.")
public enum ParticipantType {

    AIR("AIR", "Airline"),
    APT("APT", "Airport Authority"),
    AGT("AGT", "Agent"),
    BRK("BRK", "Broker"),
    CAG("CAG", "Commission Agent"),
    CNE("CNE", "Consignee"),
    CTM("CTM", "Customs"),
    DCL("DCL", "Declarant"),
    DEC("DEC", "Deconsolidator"),
    FFW("FFW", "Freight Forwarder"),
    GHA("GHA", "Ground Handling Agent"),
    PTT("PTT", "Post Office"),
    SHP("SHP", "Shipper"),
    TRK("TRK", "Trucker");

    public final String cargoImpCode;
    public final String description;

    ParticipantType(String cargoImpCode, String description) {
        this.cargoImpCode = cargoImpCode;
        this.description = description;
    }

    public static ParticipantType fromCargoImpCode(String cargoImpCode) {
        return Stream.of(values()).filter(v -> v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }
}
