package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.Map;
import java.util.Objects;


public class Fault   {
  
  private @Valid String faultstring;
  private @Valid Map<String,Object> detail = null;

  /**
   **/
  public Fault faultstring(String faultstring) {
    this.faultstring = faultstring;
    return this;
  }

  

  
  @Schema(description = "", example = "Unable to retrieve the requested data. See rootcause section for details.")
  @JsonProperty("faultstring")
  public String getFaultstring() {
    return faultstring;
  }

  public void setFaultstring(String faultstring) {
    this.faultstring = faultstring;
  }/**
   **/
  public Fault detail(Map<String,Object> detail) {
    this.detail = detail;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("detail")
  public Map<String,Object> getDetail() {
    return detail;
  }

  public void setDetail(Map<String,Object> detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fault fault = (Fault) o;
    return Objects.equals(this.faultstring, fault.faultstring) &&
        Objects.equals(this.detail, fault.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(faultstring, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fault {\n");
    
    sb.append("    faultstring: ").append(toIndentedString(faultstring)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

