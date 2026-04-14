package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.common.DataQuality;
import aero.champ.cargojson.common.FlightIdentity;
import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.events.Departed;
import aero.champ.cargojson.flightstatus.events.InFlight;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlightState {
    private final String iataFlightNumber;
    private final LocalDateTime statusTS;
    private final FlightStateSource flightStateSource;
    private String iataDepartureAirport;
    private String iataArrivalAirport;
    private LocalDateTime filedDepartureTime;
    private LocalDateTime actualDepartureTime;
    private LocalDateTime actualArrivalTime;
    private LocalDateTime estimatedArrivalTime;
    private int plannedflightTime;
    private Double longitude;
    private Double latitude;

    public FlightState(String iataFlightNumber, LocalDateTime statusTS, FlightStateSource flightStateSource) {
        this.iataFlightNumber = iataFlightNumber;
        this.statusTS = statusTS;
        this.flightStateSource = flightStateSource;
    }

    public long getAgeInSecs() {
        return ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond() - statusTS.toEpochSecond(ZoneOffset.UTC);
    }

    public String getIataFlightNumber() {
        return iataFlightNumber;
    }

    public LocalDateTime getStatusTS() {
        return statusTS;
    }

    public String getIataDepartureAirport() {
        return iataDepartureAirport;
    }

    public void setIataDepartureAirport(String iataDepartureAirport) {
        this.iataDepartureAirport = iataDepartureAirport;
    }

    public String getIataArrivalAirport() {
        return iataArrivalAirport;
    }

    public void setIataArrivalAirport(String iataArrivalAirport) {
        this.iataArrivalAirport = iataArrivalAirport;
    }

    public LocalDateTime getFiledDepartureTime() {
        return filedDepartureTime;
    }

    public void setFiledDepartureTime(LocalDateTime filedDepartureTime) {
        this.filedDepartureTime = filedDepartureTime;
    }

    public LocalDateTime getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(LocalDateTime actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public LocalDateTime getActualArrivalTime() {
        return actualArrivalTime;
    }

    public void setActualArrivalTime(LocalDateTime actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public int getPlannedflightTime() {
        return plannedflightTime;
    }

    public void setPlannedflightTime(int plannedflightTime) {
        this.plannedflightTime = plannedflightTime;
    }

    public void setPlannedflightTime(String hhmmss) {
        if (hhmmss == null || hhmmss.isEmpty())
            return;
        String[] timeData = hhmmss.split(":");
        if (timeData.length != 3)
            return;
        this.plannedflightTime = Integer.parseInt(timeData[0]) * 60 + Integer.parseInt(timeData[1]);
    }

    public FlightStateSource getFlightStateSource() {
        return flightStateSource;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "FlightState{" +
                "iataFlightNumber='" + iataFlightNumber + '\'' +
                ", statusTS=" + statusTS +
                ", iataDepartureAirport='" + iataDepartureAirport + '\'' +
                ", iataArrivalAirport='" + iataArrivalAirport + '\'' +
                ", filedDepartureTime=" + filedDepartureTime +
                ", actualDepartureTime=" + actualDepartureTime +
                ", actualArrivalTime=" + actualArrivalTime +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", plannedflightTime=" + plannedflightTime +
                ", flightStateSource=" + flightStateSource +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public InFlight convertToInflight(Departed departed, Function<String, ZoneId> airportCodeToZoneId) {
        InFlight inflight = new InFlight();
        inflight.flight = new FlightIdentity(this.iataFlightNumber);
        inflight.destination = new IATAAirportCode(this.getIataArrivalAirport());
        inflight.origin = new IATAAirportCode(this.getIataDepartureAirport());
        if (this.getLatitude() != null)
            inflight.ecefLatitude = this.getLatitude();
        if (this.getLongitude() != null)
            inflight.ecefLongitude = this.getLongitude();
        inflight.timeOfEvent = this.getStatusTS();
        inflight.timeOfEventTimePartQuality = DataQuality.SUPPLIED;
        ZoneId originAirport = airportCodeToZoneId.apply(inflight.origin.code());
        ZoneId destinationAirport = airportCodeToZoneId.apply(inflight.destination.code());
/*        ZoneId originAirport = Airports.INSTANCE.getByIataCode(inflight.origin.code()).flatMap(ap -> ap.zoneId).orElse(null);
        ZoneId destinationAirport = Airports.INSTANCE.getByIataCode(inflight.destination.code()).flatMap(ap -> ap.zoneId).orElse(null);

 */

        inflight.estimatedTimeOfArrival = Optional.ofNullable(this.getEstimatedArrivalTime()).map(t -> shiftTime(destinationAirport, t));
        inflight.actualTimeOfDeparture = Optional.ofNullable(this.getActualDepartureTime()).map(t -> shiftTime(originAirport, t));
        inflight.scheduledTimeOfDeparture = Optional.ofNullable(this.getFiledDepartureTime()).map(t -> shiftTime(originAirport, t));
        inflight.actualTimeOfArrival = Optional.ofNullable(this.getActualArrivalTime()).map(t -> shiftTime(destinationAirport, t));
        if (this.getPlannedflightTime() != 0) {
            inflight.plannedflightTime = Optional.of(this.getPlannedflightTime());
            if (inflight.scheduledTimeOfDeparture.isPresent() && (originAirport != null && destinationAirport != null)) {
                inflight.scheduledTimeOfArrival = Optional.of(
                        inflight.scheduledTimeOfDeparture.get().atZone(originAirport).plusSeconds(inflight.plannedflightTime.get()).withZoneSameInstant(destinationAirport).toLocalDateTime());


            }
        }
        if (inflight.scheduledTimeOfArrival.isPresent() && inflight.estimatedTimeOfArrival.isPresent())
            inflight.estimatedDiffToSchedule = Optional.of((int) Duration.between(inflight.scheduledTimeOfArrival.get(), inflight.estimatedTimeOfArrival.get()).toMinutes());
        inflight.numberOfPieces = departed.numberOfPieces;
        inflight.weight = departed.weight;
        inflight.uld = new ArrayList<>(departed.uld);

        return inflight;
    }

    private LocalDateTime shiftTime(ZoneId zone, LocalDateTime t) {
        return zone != null ? t.atZone(ZoneOffset.UTC).withZoneSameInstant(zone).toLocalDateTime() : t;
    }

    public enum FlightStateSource {
        FSU, FSA, FLIGHTAWARE
    }

}
