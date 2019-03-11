package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.DimensionInfo;
import aero.champ.cargojson.common.MovementPriorityCode;
import aero.champ.cargojson.common.OCI;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Specifies the consigments loaded, and if no bulk the ULD container containing it")
public class LoadedCargo {

    public Optional<ULDInformation> uldInformation = Optional.empty();
    @JsonProperty(required = true)
    public List<Consignment> consignments = new ArrayList<>();



}
