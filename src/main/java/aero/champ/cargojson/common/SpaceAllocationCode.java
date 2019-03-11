package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Space Allocation Code: Coded indication of the action requested, taken or confirmed related to space allocation.")
public enum SpaceAllocationCode {
    XX("XX", "Cancel Any Previous Space Allocatiomn"),
    SS("SS", "Reporting Sale"),
    NA("NA", "Requesting Space Allocation, if Not Available Will Accept Alternative"),
    NL("NL", "Requesting Space Allocation, for Wait List"),
    NN("NN", "Requesting Space Allocation, Will Not Accept Alternative"),
    CA("CA", "Selling Space Allocation Against Allotment"),
    CN("CN", "Cancellation Noted"),
    KK("KK", "Confirming"),
    UU("UU", "Unable"),
    UN("UN", "Unable, Flight Does Not Operate"),
    LL("LL", "Wait List"),
    HN("HN", "Have Requested Space Allocation"),
    HK("HK",  "Holding Confirmed"),
    HL("HL", "Holding Wait List");

    public final String cargoImpCode;
    public final String description;

    SpaceAllocationCode(String cargoImpCode, String description) {
        this.cargoImpCode = cargoImpCode;
        this.description = description;
    }

    public static SpaceAllocationCode fromCargoImpCode(String code) {
        for (SpaceAllocationCode c : values()) {
            if (c.cargoImpCode.equals(code))
                return c;
        }
        return null;
    }
}
