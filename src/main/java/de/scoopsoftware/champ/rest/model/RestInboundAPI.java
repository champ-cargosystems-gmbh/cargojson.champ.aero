package de.scoopsoftware.champ.rest.model;

import aero.champ.cargojson.common.Message;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/")
@OpenAPIDefinition
public interface RestInboundAPI {

    @POST
    @Path("/{user}/{waitMode:(ANSWER|ACK|NO_WAIT)}")
    @Operation(
        summary = "Receive a Cargo Canonical Message",
        description = "Accepts a Cargo Canonical Message and processes it according to the requested waitMode. " +
            "The polymorphic type is defined by the 'type' field in the message payload. " +
            "Valid types include 'air waybill', 'flight status', 'house waybill', etc.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Message successfully processed and acknowledged. Returns the response message if applicable.",
                content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request or malformed message."),
            @ApiResponse(responseCode = "401", description = "Unauthorized.")
        }
    )
    Message<?> receiveMessage(
        @Parameter(description = "Password for authentication", required = true) @HeaderParam("password") String password, 
        @Parameter(description = "User identifier", required = true) @PathParam("user") String user, 
        @Parameter(description = "Wait mode for processing (ANSWER, ACK, NO_WAIT)", required = true) @PathParam("waitMode") String waitMode, 
        @Parameter(description = "Polymorphic Cargo Canonical Message", required = true) Message<?> message);
}
