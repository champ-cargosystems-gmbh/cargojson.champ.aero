package aero.champ.cargojson.uldexchangecontrol;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ULDExchangeControl {
    @JsonProperty(required = true)
    public List<ULDDetails> uldDetailsList;
    public String supplementaryInformation;
}
