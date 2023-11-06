package com.mrlopito.senai.exam.crud.resources;


import com.mrlopito.senai.exam.crud.application.commands.user.CreateUserCommand;
import com.mrlopito.senai.exam.crud.domain.dtos.CreateUserDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResource {
    private final CreateUserCommand createUserCommand;

    @Inject
    public UserResource(CreateUserCommand createUserCommand) {
        this.createUserCommand = createUserCommand;
    }

    @POST
    public Response create(CreateUserDTO dto) {
        createUserCommand.handle(dto);

        return Response.ok().build();
    }
}
