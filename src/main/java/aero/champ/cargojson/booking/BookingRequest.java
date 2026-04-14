package aero.champ.cargojson.booking;

import aero.champ.cargojson.common.AirWaybillNumber;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.IATACarrierCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingRequest {

    @JsonPropertyDescription("IATA Code for the consignment's main carrier.")
    @Schema(description = "IATA Code for the consignment's main carrier.")
    public Optional<IATACarrierCode> issueIataCarrierCode = Optional.empty();

    public Optional<IATAAirportCode> requestingStation = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    @Schema(description = "Airport code of origin airport.")
    public Customer customer;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    @Schema(description = "Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of origin airport.")
    @Schema(description = "Airport code of origin airport.")
    public IATAAirportCode origin;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport code of destination airport.")
    @Schema(description = "Airport code of destination airport.")
    public IATAAirportCode destination;

    //omit shipment description code as its appearance in cargo imp simply forces you to specify "T" without any extra information
    @JsonProperty(required = true)
    @JsonPropertyDescription("Total number of pieces of complete consignment.")
    @Schema(description = "Total number of pieces of complete consignment.", example = "20")
    public int totalConsignmentNumberOfPieces;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Weight of the consignment (kilogram).")
    @Schema(description = "Weight of the consignment (kilogram).")
    public BigDecimal weightKg;

    @JsonPropertyDescription("Volume of the consignment (cubic meters).")
    @Schema(description = "Volume of the consignment (cubic meters).")
    public Optional<BigDecimal> volumeMtq = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Short description of the nature of the contained goods.")
    @Schema(description = "Short description of the nature of the contained goods.", example = "Electronic parts")
    public String natureOfGoods;

    @JsonPropertyDescription("Segments to book")
    @Schema(description = "Segments to book")
    public Optional<List<Segment>> segments = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("Load type, either BULK or ULD")
    @Schema(description = "Load type, either BULK or ULD", example = "ULD")
    public LoadType loadType;

    @JsonPropertyDescription("Information on shipped pieces")
    @Schema(description = "Information on shipped pieces")
    public Optional<List<PieceDetails>> pieceDetails = Optional.empty();

    @JsonPropertyDescription("Information on shipped ULD")
    @Schema(description = "Information on shipped ULD")
    public Optional<List<ULD>> uldDetails = Optional.empty();

    @JsonPropertyDescription("Quote id")
    @Schema(description = "Quote id")
    public Optional<UUID> quoteId = Optional.empty();


}
