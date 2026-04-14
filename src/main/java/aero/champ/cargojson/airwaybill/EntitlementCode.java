package aero.champ.cargojson.airwaybill;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonClassDescription("Entitlement code: Coded identification of the recipient of a charge amount.")
@Schema(description = "Entitlement code: Coded identification of the recipient of a charge amount.")
public enum EntitlementCode {
    Agent("A"), Carrier("C");

    public final String cargoImpCode;

    EntitlementCode(String code) { this.cargoImpCode = code; }

    public static EntitlementCode fromCode(String code) {
        return Agent.cargoImpCode.equals(code) ? Agent : Carrier.cargoImpCode.equals(code) ? Carrier : null;
    }
}
