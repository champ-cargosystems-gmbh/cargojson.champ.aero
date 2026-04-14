package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Piece {
    public int pieceCount;
    public Integer length;
    public Integer width;
    public Integer height;
    public BigDecimal weight;
}
