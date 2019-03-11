package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Errors;
import io.swagger.model.Peticion;
import io.swagger.model.Respuesta;

/**
 * Vantage
 */
@Path("/")
@Api(value = "/")
public interface SegmentadorApi  {

    /**
     * Segmentador
     */
    @POST
    @Path("/v1/vantage")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = " ", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Respuesta.class),
        @ApiResponse(code = 204, message = "NO CONTENT", response = Errors.class),
        @ApiResponse(code = 400, message = "BAD REQUEST", response = Errors.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Errors.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Errors.class),
        @ApiResponse(code = 429, message = "Too Many Requests", response = Errors.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Errors.class),
        @ApiResponse(code = 503, message = "Service Unavailable", response = Errors.class) })
    public Respuesta vantage(@HeaderParam("x-api-key") String xApiKey, @HeaderParam("username") String username, @HeaderParam("password") String password, Peticion body);
}