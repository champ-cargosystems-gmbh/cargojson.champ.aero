package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.FlightEvent;
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
@JsonClassDescription("This event reports that the consignment was put into warehouse.\nConforms to CIMP FSU status 'FIW'.")
@Schema(description = "This event reports that the consignment was put into warehouse.\nConforms to CIMP FSU status 'FIW'.")
public class FreightInWarehouse extends FlightEvent {
    public FreightInWarehouse(){}

    @JsonPropertyDescription("The respective flight.")
    @Schema(description="The respective flight.")
    public Optional<FlightIdentity> flight = Optional.empty();

    @JsonProperty(required = true)
    @JsonPropertyDescription("The scheduled date of arrival for the flight.")
    @Schema(description="The scheduled date of arrival for the flight.")
    public LocalDate dateOfScheduledArrival;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The destination airport of the consignment.")
    @Schema(description="The destination airport of the consignment.")
    public IATAAirportCode destination;

    @Override
    public Optional<IATAAirportCode> airportOfEvent() {
        return Optional.ofNullable(destination);
    }

    @Override
    public Optional<FlightIdentity> flight() {
        return flight;
    }

    @Override
    public Optional<LocalDateTime> arrivalDate() {
        return Optional.ofNullable(dateOfScheduledArrival).map(LocalDate::atStartOfDay);
    }


}