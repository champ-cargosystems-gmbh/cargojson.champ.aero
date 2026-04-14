package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.flightstatus.FlightEvent;
import aero.champ.cargojson.flightstatus.events.*;

import java.util.NoSuchElementException;

public enum FlightEventType {


    Discrepancy(Discrepancy.class, "DIS"),
    ArrivalDocumentationDelivered(ArrivalDocumentationDelivered.class, "AWD"),
    ArrivalDocumentationReceived(ArrivalDocumentationReceived.class, "AWR"),
    ConsigneeNotified(ConsigneeNotified.class, "NFD"),
    Arrived(Arrived.class, "ARR"),
    Booked(Booked.class, "BKD"),
    CustomsCleared(CustomsCleared.class, "CCD"),
    CustomsOnHold(CustomsOnHold.class, "COH"),
    CustomsError(CustomsError.class, "CER"),
    TransferManifested(TransferManifested.class, "TRM"),
    Manifested(Manifested.class, "MAN"),
    Delivered(Delivered.class, "DLV"),
    DeliveredAtDoor(DeliveredAtDoor.class, "DDL"),
    ReceivedFromFlight(ReceivedFromFlight.class, "RCF"),
    ReceivedFromShipper(ReceivedFromShipper.class, "RCS"),
    ReceivedFromCarrier(ReceivedFromCarrier.class, "RCT"),
    TransferredToCarrier(TransferredToCarrier.class, "TFD"),
    FreightPrepared(FreightPrepared.class, "PRE"),
    ReportedToCustoms(ReportedToCustoms.class, "CRC"),
    TransferredToCustoms(TransferredToCustoms.class, "TGC"),
    Departed(Departed.class, "DEP"),
    FreightOnHand(FreightOnHand.class, "FOH"),
    InFlight(InFlight.class, "INF"),
    FreightInWarehouse(FreightInWarehouse.class, "FIW"),
    FreightOutWarehouse(FreightOutWarehouse.class, "FOW"),
    ;

    FlightEventType(Class<? extends FlightEvent> cargoCanonicalFlightEventClass, String displayText) {
        this.cargoCanonicalFlightEventClass = cargoCanonicalFlightEventClass;
        this.displayText = displayText;
    }

    public final Class<? extends FlightEvent> cargoCanonicalFlightEventClass;

    public final String displayText;

    public String guiString() {
        return name()+" ("+displayText+")";
    }

    public static FlightEventType fromFlightEvent(FlightEvent evt) {
        for (FlightEventType type : values()) {
            if (evt.narrow(type.cargoCanonicalFlightEventClass).isPresent())
                    return type;
        }
        throw new NoSuchElementException(evt.getClass().getCanonicalName());
    }

}
