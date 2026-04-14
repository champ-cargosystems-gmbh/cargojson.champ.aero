package de.scoopsoftware.champ.rest.model.tracking;

import aero.champ.cargojson.common.ParticipantAddressType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TTTExtendedRequest {
    @JsonProperty(required = true)
    List<String> waybillIdentification = new ArrayList<>();
    @JsonProperty(required = true)
    AddressType notifyAddressType;
    @JsonProperty(required = true)
    String notifyAddress;
    AddressType airlineAddressType;
    String airlineAddress;
    @JsonProperty()
    List<FlightEventType> forwardedEvents = new ArrayList<>();
    @JsonProperty()
    List<FlightEventType> terminatingEvents = new ArrayList<>();
    boolean forwardWaybills = false;
    boolean withEnvelope = false;


    public enum AddressType {
        PIMA(ParticipantAddressType.PIMA),
        TTY(ParticipantAddressType.TTY),
        WEBHOOK(ParticipantAddressType.WEBSITE);

        public final ParticipantAddressType canonicalType;

        AddressType(ParticipantAddressType canonicalType) {
            this.canonicalType = canonicalType;
        }
    }

    public List<String> waybillIdentification() {
        return waybillIdentification;
    }

    public Optional<String> airlineAddress() {
        return Optional.ofNullable(airlineAddress);
    }

    public Optional<AddressType> airlineAddressType() {
        return Optional.ofNullable(airlineAddressType);
    }

    public AddressType notifyAddressType() {
        return notifyAddressType;
    }

    public String notifyAddress() {
        return notifyAddress;
    }

    public List<FlightEventType> forwardedEvents() {
        return forwardedEvents;
    }

    public List<FlightEventType> terminatingEvents() {
        return terminatingEvents;
    }

    public boolean forwardWaybills() {
        return forwardWaybills;
    }

    public boolean withEnvelope() {
        return withEnvelope;
    }
}