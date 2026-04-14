package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalsInformation {
    @JsonProperty(required = true)
    public String mailClass;
    @JsonProperty(required = true)
    public int numberOfReceptacles;
    @JsonIgnore
    public int quantity;
    @JsonProperty(required = true)
    public double weightOfReceptables;
}
