package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Optional;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Code representing a specific rate category.")
public enum RateClassCode {

    BASIC_CHARGE("B", "6")
    ,CLASS_RATE_REDUCTION("R", null)
    ,CLASS_RATE_SURCHARGE("S", null)
    ,INTERNATIONAL_PRIORITY_SERVICE_RATE("P", null)
    ,MINIMUM_CHARGE("M", "8")
    ,NORMAL_RATE("N", "9")
    ,QUANTITY_RATE("Q", "10")
    ,RATE_PER_KILOGRAM("K", "7")
    ,SPECIFIC_COMMODITY_RATE("C", null)
    ,UNIT_LOAD_DEVICE_ADDITIONAL_INFORMATION("X", null)
    ,UNIT_LOAD_DEVICE_ADDITIONAL_RATE("E", null)
    ,UNIT_LOAD_DEVIDE_BASIC_CHARGE_OR_RATE("U", null)
    ,UNIT_LOAD_DEVICE_DISCOUNT("Y", null)
            ;

    public final String cargoImpCode;
    private final String cargoFactCode;
    public Optional<String> cargoFactCode() {
        return Optional.ofNullable(cargoFactCode);
    }

    RateClassCode(String cargoImpCode, String cargoFactCode) {
        this.cargoImpCode = cargoImpCode;
        this.cargoFactCode = cargoFactCode;
    }

    public static RateClassCode fromCargoImp(String cargoImpCode) {
        return Stream.of(values()).filter(v->v.cargoImpCode.equals(cargoImpCode)).findFirst().get();
    }


}
