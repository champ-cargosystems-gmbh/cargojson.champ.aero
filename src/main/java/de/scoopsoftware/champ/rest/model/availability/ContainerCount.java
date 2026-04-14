package de.scoopsoftware.champ.rest.model.availability;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ContainerCount {

    @NotNull
    @Schema(description = "Container type (such as LD2)")
    public String container;

    @NotNull
    @Schema(description = "Number of containers")
    public int count;

    public BigDecimal weight;

}
