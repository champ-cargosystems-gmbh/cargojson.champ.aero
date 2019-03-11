package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.Pattern;

@JsonClassDescription("Air waybill number used to identify an air cargo entity.")
public class AirWaybillNumber {

    @JsonIgnore
    public final String awbNumber;

    @JsonCreator
    public AirWaybillNumber(@Pattern(regexp = "[0-9]{3}-[0-9]{8}") String awbNumber) {
        this.awbNumber = awbNumber;
    }

    @JsonValue
    @JsonDocExample("020-97162321")
    @JsonPropertyDescription("A string consisting of a 3-digit airline number, followed by a hyphen, followed by an 8-digit number. " +
            "Regular expression: [0-9]{3}-[0-9]{8}")
    public String awbNumber() {
        return awbNumber;
    }

    public String airlinePrefix() {
        return awbNumber.substring(0,3);
    }

    public String serialNumber() {
        return awbNumber.substring(4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirWaybillNumber that = (AirWaybillNumber) o;

        return awbNumber.equals(that.awbNumber);
    }

    @Override
    public int hashCode() {
        return awbNumber.hashCode();
    }

    @Override
    public String toString() {
        return awbNumber();
    }
}
