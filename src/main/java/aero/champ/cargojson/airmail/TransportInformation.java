package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TransportInformation {
    @JsonProperty(required = true)
    public String transportStageQualifier;
    public String carrierCode;
    public String carrierCodeSource;
    public String carrierName;
    public String conveyanceReference;
    public String modeOfTransport;
    public String departureLocationCode;
    public String departureLocationCodeSource;
    public String departureLocationName;
    public LocalDateTime transportDepartureDateTime;
    public String arrivalLocationCode;
    public String arrivalLocationCodeSource;
    public String arrivalLocationName;
    public LocalDateTime transportArrivalDateTime;
    public String transportLegRateCode;
    public String transportLegContract;
}
