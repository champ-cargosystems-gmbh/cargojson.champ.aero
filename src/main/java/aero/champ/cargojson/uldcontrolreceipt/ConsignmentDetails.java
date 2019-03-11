package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Andy on 12/4/2017.
 */
public class ConsignmentDetails {
    @JsonProperty(required = true)
    public String waybillNumber;
    @JsonProperty(required = true)
    public ConsignmentOrigin consignmentOrigin = new ConsignmentOrigin();
    @JsonProperty(required = true)
    public ConsignmentDestination consignmentDestination = new ConsignmentDestination();
    @JsonProperty(required = true)
    public boolean shipmentTotalFlag;
    @JsonProperty(required = true)
    public int pieces;
    public int totalPieces;
    @JsonProperty(required = true)
    public String weightUnitMeasurement;
    @JsonProperty(required = true)
    public double grossWeight;
    public int shippersLoadAndCount;
    @JsonProperty(required = true)
    public String natureOfGoods;

}
