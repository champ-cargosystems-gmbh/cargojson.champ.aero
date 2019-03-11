package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Enumeration for Cargo Canonical message interchange types.")
public enum InterchangeType {

        AirWayBillDataRequest,
        AirWayBill,
        Cancellation,
        ErrorMessage,
        UNKNOWN,
        CustomsStatusNotification,
        FreightBookedList,
        SpaceAllocationRequest,
        SpaceAllocationAnswer,
        SpaceAllocationChange,
        FlightManifest,
        ConsolidationList,
        Acknowledgement,
        StatusRequest,
        StatusAnswer,
        StatusUpdate,
        RateInformationAnswer,
        ScheduleAndAvailabilityRequest,
        ScheduleAndAvailabilityAnswer,
        CCSFreeText,
        HouseWaybillData,
        ScheduleInformationRequest,
        HouweWaybillStatusRequest,
        HouseWaybillStatusAnswer,
        HouseWaybillStatusUpdate,
        AllotmentInformationRequest,
        AllotmentInformationAnswer,
        Defective,
        GenericRequest;


}
