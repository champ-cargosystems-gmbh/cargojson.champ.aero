package aero.champ.cargojson.airlineflightmanifest;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("An airline flight manifest (FFM) is a notification of details of consigments loaded onto a flight or of details of the onward movement of a consigment loaded.")
public class AirlineFlightManifest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The message sequence provides compatibility with Cargo IMP. The first sequence number is '1'.")
    public int messageSequence;
    @JsonPropertyDescription("Indicated the presence of a related message. That message will contain the next higher sequence number.")
    @JsonProperty(required = true)
    public boolean hasContinuation;

    @JsonProperty(required = true)
    public FlightIdAndPointOfLoading flightIdAndPointOfLoading;
    @JsonProperty(required = true)
    public List<PointOfUnloading> pointOfUnloading = new ArrayList<>();




}
