package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.Objects;


public class Carrier   {
  
  private @Valid String code;

  /**
   * ICAO airline designator, coded identification for a carrier.
   **/
  public Carrier code(String code) {
    this.code = code;
    return this;
  }

  

  
  @Schema(description = "ICAO airline designator, coded identification for a carrier.", example = "XS")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Carrier carrier = (Carrier) o;
    return Objects.equals(this.code, carrier.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Carrier {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

