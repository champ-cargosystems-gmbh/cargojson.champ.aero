package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;


public class CarrierError {

  public String carrier;
  private @Valid Object fault;

  /**
   **/
  public CarrierError fault(Object fault) {
    this.fault = fault;
    return this;
  }




  @Schema()
  @JsonProperty("fault")
  public Object getFault() {
    return fault;
  }

  public void setFault(Object fault) {
    this.fault = fault;
  }

}

