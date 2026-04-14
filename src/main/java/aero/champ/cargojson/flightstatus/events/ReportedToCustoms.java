package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("This event reports that the consignment was reported to customs.\nConforms to CIMP FSU status 'CRC'.")
@Schema(description = "This event reports that the consignment was reported to customs.\nConforms to CIMP FSU status 'CRC'.")
public class ReportedToCustoms extends CustomsEvent {
    public ReportedToCustoms(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("The airport where the consignment was reported to customs.")
    @Schema(description="The airport where the consignment was reported to customs.")
    public IATAAirportCode airportOfReporting;

    @JsonPropertyDescription("The flight the consignment is or was loaded on.")
    @Schema(description="The flight the consignment is or was loaded on.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonPropertyDescription("The scheduled departure date of the flight.")
    @Schema(description="The scheduled departure date of the flight.")
    public Optional<LocalDate> dateOfScheduledDeparture = Optional.empty();

    @JsonPropertyDescription("The origin airport of the flight.")
    @Schema(description="The origin airport of the flight.")
    public Optional<IATAAirportCode> origin = Optional.empty();

    @JsonPropertyDescription("The destination airport of the flight.")
    @Schema(description="The destination airport of the flight.")
    public Optional<IATAAirportCode> destination = Optional.empty();

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(airportOfReporting);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }

    public Optional<LocalDateTime> departureDate() {
        return dateOfScheduledDeparture. map(d->LocalDateTime.of(d, LocalTime.MIN));
    }
}
