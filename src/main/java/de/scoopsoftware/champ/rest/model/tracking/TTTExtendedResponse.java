package de.scoopsoftware.champ.rest.model.tracking;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class TTTExtendedResponse {
    @JsonProperty(required = true)
    List<TTTWaybillConfirmation> confirmations = new ArrayList<>();

    public List<TTTWaybillConfirmation> confirmations() {
        return confirmations;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static final class TTTWaybillConfirmation {

        @JsonProperty(required = true, value = "waybillIdentification")
        final String waybillIdentification;
        @JsonProperty("endOfLife")
        final LocalDateTime endOfLife;
        @JsonProperty("error")
        final String error;

        @JsonCreator
        public TTTWaybillConfirmation(@JsonProperty("waybillIdentification") String waybillIdentification, @JsonProperty("endOfLife") LocalDateTime endOfLife, @JsonProperty("error") String error) {
            this.waybillIdentification = waybillIdentification;
            this.endOfLife = endOfLife;
            this.error = error;
        }

        public String waybillIdentification() {
            return waybillIdentification;
        }

        public LocalDateTime endOfLife() {
            return endOfLife;
        }

        public String error() {
            return error;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TTTWaybillConfirmation)) return false;
            TTTWaybillConfirmation that = (TTTWaybillConfirmation) o;
            return Objects.equals(waybillIdentification, that.waybillIdentification) && Objects.equals(endOfLife, that.endOfLife) && Objects.equals(error, that.error);
        }

        @Override
        public int hashCode() {
            return Objects.hash(waybillIdentification, endOfLife, error);
        }
    }


}
