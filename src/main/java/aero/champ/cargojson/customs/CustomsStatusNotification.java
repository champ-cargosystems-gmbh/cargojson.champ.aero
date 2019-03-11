package aero.champ.cargojson.customs;

import aero.champ.cargojson.common.*;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomsStatusNotification {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Contains the air waybill number.")
    public AirWaybillNumber airWaybillNumber;

    @JsonPropertyDescription("Master AWB Indication, included if House Waybills are associated with the AWB.")
    public Optional<Boolean> isMasterAWB = Optional.empty();

    @JsonPropertyDescription("House Waybill Serial Number if applicable.")
    @JsonDocExample("12345678ABCD")
    public Optional<String> houseWayBillSerialNumber = Optional.empty();

    @JsonPropertyDescription("Optional information on wether the message is security or customs related. Background. CIMP CSN messages are often used to convey security information.")
    public Optional<Relation> relation = Optional.empty();

    @JsonPropertyDescription("IATA Code for the flight's carrier if known. At least one of iataCarrierCode or icaoCarrierCode has to be provided.")
    public Optional<IATACarrierCode> iataCarrierCode = Optional.empty();

    @JsonPropertyDescription("IATA Code for the flight's carrier if known. At least one of iataCarrierCode or icaoCarrierCode has to be provided.")
    public Optional<ICAOCarrierCode> icaoCarrierCode = Optional.empty();

    @JsonProperty(required = true)
    public FlightNumber flightNumber;

    @JsonProperty(required = true)
    public IATAAirportCode airportCodeOfLoading;

    @JsonProperty(required = true)
    public IATAAirportCode airportCodeOfUnloading;

    @JsonProperty(required = true)
    public LocalDate dateOfScheduledArrival;

    public Optional<IATAAirportCode> airportCodeOfFirstEntryPoint = Optional.empty();

    public List<CustomsAction> customsActions = new ArrayList<>();

}
