package com.example.controller;

import com.example.model.Person;
import com.example.service.HelloWorldService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/people")
public class HelloWorldController {
    private HelloWorldService helloWorldService;
    @Inject
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPeople() {

        return Response.status(Response.Status.OK).entity(helloWorldService.getAllPeople()).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        helloWorldService.addPerson(person);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") Long id,Person personUpdate){
        return Response.status(Response.Status.ACCEPTED).entity(helloWorldService.updatePerson(personUpdate,id)).build();

    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).entity(helloWorldService.deletePerson(id)).build();
    }

}