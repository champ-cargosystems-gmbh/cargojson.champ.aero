package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.Objects;
import java.util.Optional;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Location   {
  
  private @Valid String code;

    public enum TypeEnum {

    AIRPORT(String.valueOf("AIRPORT")), CITY(String.valueOf("CITY"));


    private String value;

    TypeEnum (String v) {
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
    public static TypeEnum fromValue(String value) {
        for (TypeEnum b : TypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  private @Valid TypeEnum type;
  private @Valid String name;
  private @Valid String timeArea;

  /**
   * Coded representation of a specific airport/city code.
   **/
  public Location code(String code) {
    this.code = code;
    return this;
  }

  

  
  @Schema(description = "Coded representation of a specific airport/city code.", example = "NRT")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }/**
   * Airport or city.
   **/
  public Location type(TypeEnum type) {
    this.type = type;
    return this;
  }

  

  
  @Schema(description = "Airport or city.", example = "AIRPORT")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }/**
   * Full name of the airport / city.
   **/
  public Location name(String name) {
    this.name = name;
    return this;
  }

  

  
  @Schema(description = "Full name of the airport / city.", example = "Narita International Airport")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }/**
   * Time zone linked to the airport / city.
   **/
  public Location timeArea(String timeArea) {
    this.timeArea = timeArea;
    return this;
  }

  

  
  @Schema(description = "Time zone linked to the airport / city.", example = "Asia/Tokyo")
  @JsonProperty("timeArea")
  public String getTimeArea() {
    return timeArea;
  }

  public void setTimeArea(String timeArea) {
    this.timeArea = timeArea;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.code, location.code) &&
        Objects.equals(this.type, location.type) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.timeArea, location.timeArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, type, name, timeArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    timeArea: ").append(toIndentedString(timeArea)).append("\n");
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

