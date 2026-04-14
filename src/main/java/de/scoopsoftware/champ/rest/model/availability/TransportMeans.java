package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransportMeans {
  
  private @Valid String id;
  private @Valid String reference;
  private @Valid LocalDate date;
  private @Valid ModeEnum mode;
  private @Valid Carrier carrier;
  private @Valid String transportNumber;
  private @Valid LocalDateTime scheduledDeparture;
  private @Valid LocalDateTime scheduledArrival;
  private @Valid TransportMeansType type;


  public enum ModeEnum {

    AIR(String.valueOf("AIR")), ROAD(String.valueOf("ROAD")), SEA(String.valueOf("SEA")), RAIL(String.valueOf("RAIL"));


    private String value;

    ModeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ModeEnum fromValue(String value) {
        for (ModeEnum b : ModeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}


  /**
   * Cargospot (system internal) unique identifier for this transport means.
   **/
  public TransportMeans id(String id) {
    this.id = id;
    return this;
  }

  

  
  @Schema(description = "Cargospot (system internal) unique identifier for this transport means.", example = "3274961")
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }/**
   * Business reference for this transport. Format: &lt;ICAO Carrier Code&gt;&lt;flight / truck number&gt;/&lt;flight / truck date in DDMMM&gt;.
   **/
  public TransportMeans reference(String reference) {
    this.reference = reference;
    return this;
  }

  

  
  @Schema(description = "Business reference for this transport. Format: <ICAO Carrier Code><flight / truck number>/<flight / truck date in DDMMM>.", example = "XS706/25DEC")
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }/**
   * Flight / truck date in format YYYY-MM-DD.
   **/
  public TransportMeans date(LocalDate date) {
    this.date = date;
    return this;
  }

  

  
  @Schema(description = "Flight / truck date in format YYYY-MM-DD.", example = "Fri Dec 25 01:00:00 CET 2020")
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }/**
   * Mode of transport.
   **/
  public TransportMeans mode(ModeEnum mode) {
    this.mode = mode;
    return this;
  }

  

  
  @Schema(description = "Mode of transport.", example = "AIR")
  @JsonProperty("mode")
  public ModeEnum getMode() {
    return mode;
  }

  public void setMode(ModeEnum mode) {
    this.mode = mode;
  }/**
   **/
  public TransportMeans carrier(Carrier carrier) {
    this.carrier = carrier;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("carrier")
  public Carrier getCarrier() {
    return carrier;
  }

  public void setCarrier(Carrier carrier) {
    this.carrier = carrier;
  }/**
   * Reference number for this transport (e.g. flight number).
   **/
  public TransportMeans transportNumber(String transportNumber) {
    this.transportNumber = transportNumber;
    return this;
  }

  

  
  @Schema(description = "Reference number for this transport (e.g. flight number).", example = "706")
  @JsonProperty("transportNumber")
  public String getTransportNumber() {
    return transportNumber;
  }

  public void setTransportNumber(String transportNumber) {
    this.transportNumber = transportNumber;
  }/**
   * Scheduled departure time in local time of departing station.
   **/
  public TransportMeans scheduledDeparture(LocalDateTime scheduledDeparture) {
    this.scheduledDeparture = scheduledDeparture;
    return this;
  }

  

  
  @Schema(description = "Scheduled departure time in local time of departing station.", example = "2020-12-25T11:30:00")
  @JsonProperty("scheduledDeparture")
  public LocalDateTime getScheduledDeparture() {
    return scheduledDeparture;
  }

  public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
    this.scheduledDeparture = scheduledDeparture;
  }/**
   * Scheduled arrival time in local time of arriving station.
   **/
  public TransportMeans scheduledArrival(LocalDateTime scheduledArrival) {
    this.scheduledArrival = scheduledArrival;
    return this;
  }

  

  
  @Schema(description = "Scheduled arrival time in local time of arriving station.", example = "2020-12-26T13:45:00")
  @JsonProperty("scheduledArrival")
  public LocalDateTime getScheduledArrival() {
    return scheduledArrival;
  }

  public void setScheduledArrival(LocalDateTime scheduledArrival) {
    this.scheduledArrival = scheduledArrival;
  }/**
   **/
  public TransportMeans type(TransportMeansType type) {
    this.type = type;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("type")
  public TransportMeansType getType() {
    return type;
  }

  public void setType(TransportMeansType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransportMeans transportMeans = (TransportMeans) o;
    return Objects.equals(this.id, transportMeans.id) &&
        Objects.equals(this.reference, transportMeans.reference) &&
        Objects.equals(this.date, transportMeans.date) &&
        Objects.equals(this.mode, transportMeans.mode) &&
        Objects.equals(this.carrier, transportMeans.carrier) &&
        Objects.equals(this.transportNumber, transportMeans.transportNumber) &&
        Objects.equals(this.scheduledDeparture, transportMeans.scheduledDeparture) &&
        Objects.equals(this.scheduledArrival, transportMeans.scheduledArrival) &&
        Objects.equals(this.type, transportMeans.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reference, date, mode, carrier, transportNumber, scheduledDeparture, scheduledArrival, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransporMeans {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    transportNumber: ").append(toIndentedString(transportNumber)).append("\n");
    sb.append("    scheduledDeparture: ").append(toIndentedString(scheduledDeparture)).append("\n");
    sb.append("    scheduledArrival: ").append(toIndentedString(scheduledArrival)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

