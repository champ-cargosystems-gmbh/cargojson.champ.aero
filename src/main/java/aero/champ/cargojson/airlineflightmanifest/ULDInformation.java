package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.ULD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ULDInformation {

    @JsonProperty(required = true)
    public ULD uld;
    public List<RoutingAndBooking> onwardRoutingAndBooking = new ArrayList<>();
    public Optional<Integer> percentAvailableVolume = Optional.empty();

}
