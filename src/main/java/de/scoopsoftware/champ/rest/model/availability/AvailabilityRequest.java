package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AvailabilityRequest {


    @NotNull
    @Schema(description = "Pair of Carrier code and account. Only flights/trucks that have this carrier code will be returned. The account number for the participant (Agent) should exist. Agent specific rates will be applied based on this account number. Example - 14000110001.")
    public Map<String, String> accounts;

    @NotNull
    @Schema(description = "Origin airport code, example SIN.")
    public String originAirportCode;

    @NotNull
    @Schema(description = "Destination airport code, example LHR.")
    public String destinationAirportCode;

    @NotNull
    @Schema(description = "The date of departure on which the user wishes to check the availability.Time is in local date/time in ISO8601 with offset format, Example 2020-12-24T20:30:00+0800.")
    public LocalDate departureOn;

    @NotNull
    @Schema(description = "Actual weight of the shipment, accept 1 decimal, Example 150.5 ")
    public Float weight;

    @Schema(description = "This classifier is used to identify the booking type. Use U if it’s a ULD shipment and use either S or B if its a loose shipment. S indicates that it’s a small shipment with weight less than or equal to 250 Kg and B indicates that it’s a big shipment with weight greater than 250 Kg.")
    public BookingType bookingType;


    @Schema(description = "Number of stops from origin until the destination. For direct flights, use maximumStops&#x3D;1. If this field is not passed, direct and multi stop itineraries will be returned. 0 is an invalid option.")
    public Integer maximumStops;

    @Schema(description = "Number of days from departureOn for which the user wishes to check the availability. If not specified, default will be 0. If you pass \"departOn\" = 2020-12-24 and \"days\" = 3 then the system will search from 24-Dec to 26-Dec inclusive of the departureOn date. If you provide both \"days\" and \"arrivalOn\" then days will take precedence. ")
    public int days = 0;

    @Schema(description = "Special handling codes to consider while checking availability, example PER.")
    public List<String> specialHandlingCodes;

    @Schema(description = "Container type (such as LD2) with number of requested containers. This parameter will be considered only when the bookingType value is U.")
    public List<ContainerCount> containers;

    @Schema(description = "Filter for itineraries that allow for an over sized shipment, default will be false (not over sized). This parameter requires specialHandlingCodes&#x3D;OSC filter to be filled as well. This parameter will only work with specific airline instances.")
    public boolean overSize = false;

    @Schema(description = "Filter for itineraries that allow for a must fly shipment, default will be false (shipment is not must fly). This parameter will only work with specific airline instances.")
    public boolean mustFly = false;

    @Schema(description = "To check whether the booking is allowed to breakdown, default will be false. This parameter will only work with specific airline instances.")
    public boolean breakDown = false;

    @Schema(description = "Actual volume of the shipment in cubic meters, Example 3.125")
    public Float volume;

    @Schema(description = "Weight of the dry ICE required by the shipment, accept 1 decimal, Example 10.5. Only flights that allow dry ice will be shown.")
    public Float dryIceWeight;

    //Next two as required by IAG
    @Schema()
    public String commodityCode;

    @Schema()
    public String product; //product example: "PRIORITISE" laut IAG

    @Schema()
    public List<Piece> pieces; //IAG


}
