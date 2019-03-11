package aero.champ.cargojson.airlineflightmanifest;

import aero.champ.cargojson.common.IATAAirportCode;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Specifies the airpoint of unloading and the respective loaded cargo")
public class PointOfUnloading {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport of unloading")
    public IATAAirportCode airportCode;
    @JsonPropertyDescription("The date of arrival at the destination")
    public Optional<LocalDateTime> dateOfArrival = Optional.empty();
    @JsonPropertyDescription("The date of departure at the orifin")
    public Optional<LocalDateTime> dateOfDeparture = Optional.empty();
    @JsonPropertyDescription("The cargo unloaded at the specified airport")
    public List<LoadedCargo> loadedCargo = new ArrayList<>();


}
