package aero.champ.cargojson.airwaybill;

import aero.champ.cargojson.common.Dimensions;
import aero.champ.cargojson.common.ULD;
import aero.champ.cargojson.common.Volume;
import aero.champ.cargojson.common.Weight;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Packaging details of goods. The fields are optional, but at least one should be filled.")
@Schema(description = "Packaging details of goods. The fields are optional, but at least one should be filled.")
public class Packaging {

    @JsonPropertyDescription("Number of pieces: Number of loose items and/or ULD's as accepted for carriage.")
    @Schema(description = "Number of pieces: Number of loose items and/or ULD's as accepted for carriage.", example = "8")
    public Optional<Integer> numberOfPieces = Optional.empty();

    @JsonPropertyDescription("Weight of the goods.")
    @Schema(description="Weight of the goods.")
    public Optional<Weight> weight = Optional.empty();

    @JsonPropertyDescription("Volume of the goods.")
    @Schema(description="Volume of the goods.")
    public Optional<Volume> volume = Optional.empty();

    @JsonPropertyDescription("Dimensions of the goods.")
    @Schema(description="Dimensions of the goods.")
    public Optional<Dimensions> dimensions = Optional.empty();

    @JsonPropertyDescription("Unit Load Device (ULD) data.")
    @Schema(description="Unit Load Device (ULD) data.")
    public Optional<ULD> uld = Optional.empty();

    @JsonPropertyDescription("Shipper's load and count.")
    @Schema(description = "Shipper's load and count.", example = "15000")
    public Optional<Integer> shippersLoadAndCount = Optional.empty();

}
