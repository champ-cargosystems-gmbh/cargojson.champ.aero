package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.Dimensions;
import aero.champ.cargojson.common.ULD;
import aero.champ.cargojson.common.Volume;
import aero.champ.cargojson.common.Weight;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Packaging details of goods. The fields are optional, but at least one should be filled.")
public class Packaging {

    @JsonPropertyDescription("Number of pieces: Number of loose items and/or ULD's as accepted for carriage.")
    @JsonDocExample("8")
    public Optional<Integer> numberOfPieces = Optional.empty();

    @JsonPropertyDescription("Weight of the goods.")
    public Optional<Weight> weight = Optional.empty();

    @JsonPropertyDescription("Volume of the goods.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("Dimensions of the goods.")
    public Optional<Dimensions> dimensions = Optional.empty();

    @JsonPropertyDescription("Unit Load Device (ULD) data.")
    public Optional<ULD> uld = Optional.empty();

    @JsonPropertyDescription("Shipper's load and count.")
    @JsonDocExample("15000")
    public Optional<Integer> shippersLoadAndCount = Optional.empty();

}
