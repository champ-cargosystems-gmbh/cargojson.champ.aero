package de.scoopsoftware.champ.rest.model;

import aero.champ.cargojson.airlineflightmanifest.AirlineFlightManifest;
import de.scoopsoftware.champ.rest.model.tracking.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;

@Path("/")
@OpenAPIDefinition
@Tag(name = "Tracking", description = "Track & Trace APIs")
public interface TrackingAPI {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTLight/{awbNumber}")
    @Operation(summary = "Get basic tracking info (Light)", description = "Fetch basic track & trace information based on AWB number.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved light track & trace information.")
    @ApiResponse(responseCode = "404", description = "AWB not found.")
    TTTBasicResponse TTTLight(@Context HttpServletResponse response,
                              @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                              @Parameter(description = "Password") @HeaderParam("password") String password,
                              @Parameter(description = "Air Waybill Number", required = true) @PathParam("awbNumber") String awbNumber) throws IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTPlus/{awbNumber}")
    @Operation(summary = "Get extended tracking info (Plus)", description = "Fetch extended track & trace information based on AWB number.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved plus track & trace information.")
    @ApiResponse(responseCode = "404", description = "AWB not found.")
    TTTBasicResponse TTTPlus(@Context HttpServletResponse response,
                             @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                             @Parameter(description = "Password") @HeaderParam("password") String password,
                             @Parameter(description = "Air Waybill Number", required = true) @PathParam("awbNumber") String awbNumber) throws IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTFlight/{iataFlightNumber}")
    @Operation(summary = "Get flight tracking info", description = "Fetch tracking information based on IATA flight number.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved flight track & trace information.")
    @ApiResponse(responseCode = "404", description = "Flight not found.")
    TTTFlightResponse TTTFlight(@Context HttpServletResponse response,
                                @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                                @Parameter(description = "Password") @HeaderParam("password") String password,
                                @Parameter(description = "IATA Flight Number", required = true) @PathParam("iataFlightNumber") String iataFlightNumber) throws IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTFlightPlus/{awbNumber}")
    @Operation(summary = "Get detailed flight info for AWB", description = "Fetch detailed flight tracking info including in-flight updates based on AWB number.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved detailed flight information.")
    @ApiResponse(responseCode = "404", description = "Flight data for AWB not found.")
    TTTFlightPlusResponse TTTFlightPlus(@Context HttpServletResponse response,
                                        @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                                        @Parameter(description = "Password") @HeaderParam("password") String password,
                                        @Parameter(description = "Air Waybill Number", required = true) @PathParam("awbNumber") String awbNumber) throws IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTHistory/{awbNumber}")
    @Operation(summary = "Get tracking history", description = "Fetch full history of track & trace events for a given AWB.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved tracking history.")
    @ApiResponse(responseCode = "404", description = "History not found.")
    TTTHistoryResponse TTTHistory(@Context HttpServletResponse response,
                                  @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                                  @Parameter(description = "Password") @HeaderParam("password") String password,
                                  @Parameter(description = "Air Waybill Number", required = true) @PathParam("awbNumber") String awbNumber) throws IOException;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTExtended")
    @Operation(summary = "Get extended tracking confirmations", description = "Post an extended track & trace request for multiple AWBs to receive confirmations.")
    @ApiResponse(responseCode = "200", description = "Successfully processed extended request.")
    TTTExtendedResponse TTTPlus(@Context HttpServletResponse response,
                                @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                                @Parameter(description = "Password") @HeaderParam("password") String password,
                                @Parameter(description = "Extended Request containing multiple waybill identifications", required = true) TTTExtendedRequest request) throws IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/TTTManifest/{flight}/{scheduledDate}")
    @Operation(summary = "Get flight manifest tracking info", description = "Fetch tracking info for a given flight and scheduled date.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved manifest.")
    List<AirlineFlightManifest> TTTManifest(@Context HttpServletResponse response, 
                                            @Parameter(description = "User identifier") @HeaderParam("user") String user, 
                                            @Parameter(description = "Password") @HeaderParam("password") String password,
                                            @Parameter(description = "Flight identifier", required = true) @PathParam("flight") String flight, 
                                            @Parameter(description = "Scheduled date", required = true) @PathParam("scheduledDate") String scheduledDate);
}
