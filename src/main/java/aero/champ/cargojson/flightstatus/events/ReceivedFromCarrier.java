package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.IATACarrierCode;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was received from another airline or carrier.\nConforms to CIMP FSU status 'RCT'.")
public class ReceivedFromCarrier extends FlightEvent {
    public ReceivedFromCarrier(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The carrier transferring the consignment.")
    public IATACarrierCode transferringCarrier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Airport where the transfer takes place.")
    public IATAAirportCode airportOfTransfer;

    @JsonPropertyDescription("The carrier receiving the consignment.")
    public Optional<IATACarrierCode> receivingCarrier = Optional.empty();

    @JsonPropertyDescription("Identification of individual or company that received the consignment.")
    @JsonDocExample("Ace Shipping Co.")
    public Optional<String> receivedFromName = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfTransfer);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }



}
