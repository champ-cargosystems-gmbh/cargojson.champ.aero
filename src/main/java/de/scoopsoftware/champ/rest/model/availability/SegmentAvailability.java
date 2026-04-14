package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.Objects;
import java.util.Optional;


public class SegmentAvailability   {
  
  private @Valid
  Location onload;
  private @Valid
  Location offload;
  private @Valid
  TransportMeans transportMeans;

  /**
   **/
  public SegmentAvailability onload(Location onload) {
    this.onload = onload;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("onload")
  public Location getOnload() {
    return onload;
  }

  public void setOnload(Location onload) {
    this.onload = onload;
  }/**
   **/
  public SegmentAvailability offload(Location offload) {
    this.offload = offload;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("offload")
  public Location getOffload() {
    return offload;
  }

  public void setOffload(Location offload) {
    this.offload = offload;
  }/**
   **/
  public SegmentAvailability transportMeans(TransportMeans transportMeans) {
    this.transportMeans = transportMeans;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("transportMeans")
  public TransportMeans getTransportMeans() {
    return transportMeans;
  }

  public void setTransportMeans(TransportMeans transportMeans) {
    this.transportMeans = transportMeans;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SegmentAvailability segmentAvailability = (SegmentAvailability) o;
    return Objects.equals(this.onload, segmentAvailability.onload) &&
        Objects.equals(this.offload, segmentAvailability.offload) &&
        Objects.equals(this.transportMeans, segmentAvailability.transportMeans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onload, offload, transportMeans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SegmentAvailability {\n");
    
    sb.append("    onload: ").append(toIndentedString(onload)).append("\n");
    sb.append("    offload: ").append(toIndentedString(offload)).append("\n");
    sb.append("    transportMeans: ").append(toIndentedString(transportMeans)).append("\n");
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

