package aero.champ.cargojson.endpoints;

import aero.champ.cargojson.booking.BookingRequest;
import de.scoopsoftware.champ.rest.model.availability.AvailabilityRequest;
import de.scoopsoftware.champ.rest.model.availability.AvailabilityResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import jakarta.servlet.http.HttpServletResponse;

public interface Booking {

    @POST
    @Consumes({ "application/json" })
    @Operation(description = "Book a flight.", responses = {
            @ApiResponse(responseCode = "201",  content = @Content(schema = @Schema(implementation = Object.class)), description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
        })
    @Path("/booking")
    Response booking(
            @Context HttpServletResponse response,
            @HeaderParam("user") String user, @HeaderParam("password") String password,
            BookingRequest request
    );

    @POST
    @Consumes({ "application/json" })
    @Operation(description = "Check flight/truck availability and price.", responses = {
            @ApiResponse(responseCode = "201",  content = @Content(schema = @Schema(implementation = AvailabilityResponse.class)), description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Path("/availability")
    Object availability(
            @Context HttpServletResponse response,
            @HeaderParam("user") String user, @HeaderParam("password") String password,
            AvailabilityRequest request
    );
}
