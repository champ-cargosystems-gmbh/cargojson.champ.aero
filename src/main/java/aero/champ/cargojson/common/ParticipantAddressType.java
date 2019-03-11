package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Enumeration for the type of address of a participant in Cargo Canonical message handling.")
public enum ParticipantAddressType {

    PIMA,
    TTY,
    CARRIER_CODE_3N,
    IATA_CARRIER_CODE,
    EMAIL,
    WEBSITE,
    UNNKOWN,
    ;
}
