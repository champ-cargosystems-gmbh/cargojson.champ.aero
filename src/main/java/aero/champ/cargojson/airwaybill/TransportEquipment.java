package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.ULD;
import aero.champ.cargojson.common.Volume;
import aero.champ.cargojson.common.Weight;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class TransportEquipment {

    @JsonProperty(required = true)
    public int shippersLoadAndCount;

    //TODO: does the weight and volume declare the volume of one piece or the sum of all pieces?
    public Optional<Weight> totalWeight = Optional.empty();
    public Optional<Volume> totalVolume = Optional.empty();
    public Optional<ULD> uld = Optional.empty();

}
