package com.unitn.adapter_service.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Created by demiurgo on 11/9/15.
 */

@Path("/test")
public class Test {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    /**
     * Request #9: GET /measureTypes
     * should return the list of measures your model supports
     * @return
     */
    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    public String getMeasureTypesList() {
        return "<lol>aDSADSA</lol>";
    }
}
