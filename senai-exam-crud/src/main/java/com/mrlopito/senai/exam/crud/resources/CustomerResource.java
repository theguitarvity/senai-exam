package com.mrlopito.senai.exam.crud.resources;


import com.mrlopito.senai.exam.crud.application.commands.*;
import com.mrlopito.senai.exam.crud.domain.dtos.CreateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.dtos.UpdateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    EntityManager em;


    private final CreateCustomerCommand createCustomerCommand;
    private final UpdateCustomerCommand updateCustomerCommand;
    private final DeleteCustomerCommand deleteCustomerCommand;
    private final RetrieveAllCustomersCommand retrieveAllCustomersCommand;
    private final RetrieveCustomerByIdCommand retrieveCustomerByIdCommand;

    @Inject
    public CustomerResource(final CreateCustomerCommand createCustomerCommand, UpdateCustomerCommand updateCustomerCommand, DeleteCustomerCommand deleteCustomerCommand, RetrieveAllCustomersCommand retrieveAllCustomersCommand, RetrieveCustomerByIdCommand retrieveCustomerByIdCommand) {
        this.createCustomerCommand = createCustomerCommand;
        this.updateCustomerCommand = updateCustomerCommand;
        this.deleteCustomerCommand = deleteCustomerCommand;
        this.retrieveAllCustomersCommand = retrieveAllCustomersCommand;
        this.retrieveCustomerByIdCommand = retrieveCustomerByIdCommand;
    }

    @GET
    public Response getAll() {
        List<Customer> list = retrieveAllCustomersCommand.handle();

        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response getById(Long id) {
        Customer customer = retrieveCustomerByIdCommand.handle(id);

        return Response.ok(customer).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Long id, UpdateCustomerDTO dto) {
        updateCustomerCommand.handle(dto,id);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response update(Long id) {
        deleteCustomerCommand.handle(id);

        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response create(CreateCustomerDTO dto) {

        createCustomerCommand.handle(dto);

        return Response.ok().build();
    }
}
