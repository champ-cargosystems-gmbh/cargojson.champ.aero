package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Route   {

  public UUID quoteId = UUID.randomUUID();
  public String externalQuoteId;
  public OffsetDateTime quoteValidUntil;
  private @Valid List<SegmentAvailability> segments = new ArrayList<SegmentAvailability>();
  private @Valid Price price;
  public Carrier carrier;

//  @JsonIgnore
//  public QuoteData quoteData;


  /**
   **/
  public Route segments(List<SegmentAvailability> segments) {
    this.segments = segments;
    return this;
  }




  @Schema()
  @JsonProperty("segments")
  public List<SegmentAvailability> getSegments() {
    return segments;
  }

  public void setSegments(List<SegmentAvailability> segments) {
    this.segments = segments;
  }/**
   **/
  public Route price(Price price) {
    this.price = price;
    return this;
  }




  @Schema()
  @JsonProperty("price")
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.segments, route.segments) &&
        Objects.equals(this.price, route.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segments, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");

    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

