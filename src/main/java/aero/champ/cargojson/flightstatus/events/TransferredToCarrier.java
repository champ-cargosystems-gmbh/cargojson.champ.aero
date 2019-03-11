package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.common.IATACarrierCode;
import aero.champ.cargojson.common.TransferManifestNumber;
import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import aero.champ.cargojson.flightstatus.FlightEvent;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was transferred to another carrier/airline.\nConforms to CIMP FSU status 'TFD'.")
public class TransferredToCarrier extends FlightEvent {
    public TransferredToCarrier(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The carrier receiving the transferred consignment.")
    public IATACarrierCode receivingCarrier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport of the transfer.")
    public IATAAirportCode airportOfTransfer;

    @JsonPropertyDescription("Transfer manifest number.")
    public Optional<TransferManifestNumber> transferManifestNumber = Optional.empty();

    @JsonPropertyDescription("The carrier transferring the consignment.")
    public Optional<IATACarrierCode> transferringCarrier = Optional.empty();

    @JsonPropertyDescription("Identification of individual or company involved in the transfer of the consignment.")
    @JsonDocExample("Ace Shipping Co.")
    public Optional<String> transferredFromName = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.of(airportOfTransfer);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return Optional.empty();
    }



}