package com.unitn.adapter_service.resources;

import com.unitn.adapter_service.services.todo_ly.Task;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by demiurgo on 2/5/16.
 */



@Path("/test")
public class TestResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public Task createTask(){
        return new Task("ASDA");
    }
}
