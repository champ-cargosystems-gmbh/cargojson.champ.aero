package aero.champ.cargojson.uldcontrolreceipt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 11/30/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ULDControlReceipt {

    @JsonProperty(required = true)
    public ULDControlReceiptHeader uldControlReceiptHeader = new ULDControlReceiptHeader();

    @JsonProperty(required = true)
    public List<ULDControlReceiptBody> uldControlReceiptBody = new ArrayList<ULDControlReceiptBody>();

    public ULDControlReceiptSummary uldControlReceiptSummary = new ULDControlReceiptSummary();
}
