package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 08/29/2017.
 */
public class ReceptacleInformation {
    @JsonProperty(required = true)
    public String receptacleType;
    @JsonProperty(required = true)
    public String receptacleId;
    public String receptacleDangerousGoodsIndicator;
    public String receptacleHandlingClass;
    @JsonProperty(required = true)
    public double receptacleWeight;
    @JsonProperty(required = true)
    public String receptacleWeightType;
    public String receptacleContainer;
}
