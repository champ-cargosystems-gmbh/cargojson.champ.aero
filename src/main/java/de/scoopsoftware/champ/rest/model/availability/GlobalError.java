package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GlobalError   {
  
  private @Valid String code;
  private @Valid String userMessage;
  private @Valid List<String> fields = new ArrayList<String>();

  /**
   **/
  public GlobalError code(String code) {
    this.code = code;
    return this;
  }

  

  
  @Schema(example = "transport-means.status")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }/**
   **/
  public GlobalError userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

  

  
  @Schema(example = "Transport-means status is cancelled.")
  @JsonProperty("userMessage")
  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }/**
   **/
  public GlobalError fields(List<String> fields) {
    this.fields = fields;
    return this;
  }

  

  
  @Schema()
  @JsonProperty("fields")
  public List<String> getFields() {
    return fields;
  }

  public void setFields(List<String> fields) {
    this.fields = fields;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlobalError globalError = (GlobalError) o;
    return Objects.equals(this.code, globalError.code) &&
        Objects.equals(this.userMessage, globalError.userMessage) &&
        Objects.equals(this.fields, globalError.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, userMessage, fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlobalError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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

