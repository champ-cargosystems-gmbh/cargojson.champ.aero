package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AirmailRequest {

    @JsonProperty(required = true)
    public ConsignmentInformation consignmentInformation = new ConsignmentInformation();
    public ConsignmentSecurityInformation consignmentSecurityInformation = new ConsignmentSecurityInformation();
    public Optional<List<ApplicableRegulationInformation>> applicableRegulationInformations = Optional.empty();
    public Optional<List<PreConsigningNotificationAuthorityAndRegulation>> preConsigningNotificationAuthorityAndRegulations = Optional.empty();
    @JsonProperty(required = true)
    public List<TotalsInformation> totalsInformations;
    public Optional<HandoverOriginInformation> handoverOriginInformation = Optional.of(new HandoverOriginInformation());
    public Optional<HandoverDestinationInformation> handoverDestinationInformation = Optional.of(new HandoverDestinationInformation());
    @JsonProperty(required = true)
    public List<TransportInformation> transportInformations;
    public List<ContainerInformation> containerInformations;
    public List<ReceptacleInformation> receptacleInformations;
}
