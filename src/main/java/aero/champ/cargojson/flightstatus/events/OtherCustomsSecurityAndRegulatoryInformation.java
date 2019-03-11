package aero.champ.cargojson.flightstatus.events;

import aero.champ.cargojson.common.ULD;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("Customs, security and regulatory control information in conjunction with a list of ULDs.")
public class OtherCustomsSecurityAndRegulatoryInformation {

    public OtherCustomsSecurityAndRegulatoryInformation(){}

    @JsonProperty(required = true)
    @JsonPropertyDescription("Array of other customs, security and regulatory control information.")
    public List<aero.champ.cargojson.common.OCI> oci = new ArrayList<>();

    @JsonPropertyDescription("Array of Unit Load Device (ULD) data.")
    public List<ULD> uld = new ArrayList<>();

}
