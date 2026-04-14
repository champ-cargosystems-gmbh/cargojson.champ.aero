package aero.champ.cargojson.booking;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

public class Commodity {

    @JsonPropertyDescription("Array of harmonised commodity codes. A harmonised commodity code is a number " +
            "identifying goods for customs or statistical purposes.")
    @Schema(description = "Array of harmonised commodity codes. A harmonised commodity code is a number " +
            "identifying goods for customs or statistical purposes.", example = "427127829")
    public String commodityCode;

    //what is the difference to nature of goods
    public String commodityName;
}
