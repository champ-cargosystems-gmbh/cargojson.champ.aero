package aero.champ.cargojson.common;

import aero.champ.cargojson.docgen.annotations.JsonDocExample;
import com.fasterxml.jackson.annotation.*;

import java.util.regex.Pattern;

@JsonClassDescription("Address of a participant in Cargo Canonical message handling.")
public class ParticipantAddress {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Participant address type.")
    @JsonDocExample("PIMA")
    public final ParticipantAddressType type;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The address.")
    @JsonDocExample("REUAIR08AAL")
    public final String address;

    @JsonCreator
    public ParticipantAddress(@JsonProperty("type") ParticipantAddressType type, @JsonProperty("address") String address) {
        this.type = type;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantAddress address1 = (ParticipantAddress) o;

        if (type != address1.type) return false;
        return address.equals(address1.address);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return type+":"+address;
    }

    static final Pattern PIMA_PATTERN= Pattern.compile("[A-Z0-9]{9,29}(?:/[A-Z0-9]{4,5})?");
    static final Pattern TTY_PATTERN= Pattern.compile("[A-Z0-9]{7}");
    static final Pattern CC3N_PATTERN= Pattern.compile("[0-9]{3}");
    static final Pattern IATA_CC_PATTERN= Pattern.compile("[A-Z0-9]{2}");

    @JsonIgnore
    public boolean isValid() {
        if (type == null || address == null)
            return false;
        switch (type) {
            case PIMA: return PIMA_PATTERN.matcher(address).matches();
            case TTY: return TTY_PATTERN.matcher(address).matches();
            case CARRIER_CODE_3N: return CC3N_PATTERN.matcher(address).matches();
            case IATA_CARRIER_CODE: return IATA_CC_PATTERN.matcher(address).matches();
            default: return false;
        }
    }

    public boolean isPrefixOf(ParticipantAddress other) {
        if (type != ParticipantAddressType.PIMA || other.type != ParticipantAddressType.PIMA)
            return false;
        return other.address.length() > address.length() && other.address.startsWith(address);
    }

}
