package com.mrlopito.senai.exam.crud.resources;

import com.mrlopito.senai.exam.crud.application.commands.auth.AuthenticateUserCommand;
import com.mrlopito.senai.exam.crud.domain.dtos.AuthenticateUserDTO;
import com.mrlopito.senai.exam.crud.domain.response.AuthUserResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    private final AuthenticateUserCommand authenticateUserCommand;


    @Inject
    public AuthenticationResource(AuthenticateUserCommand authenticateUserCommand) {
        this.authenticateUserCommand = authenticateUserCommand;
    }


    @POST
    public Response auth(AuthenticateUserDTO dto) throws Exception {
        return Response.ok(authenticateUserCommand.handle(dto)).build();
    }
}
