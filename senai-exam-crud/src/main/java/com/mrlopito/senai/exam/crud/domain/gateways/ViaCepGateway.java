package com.mrlopito.senai.exam.crud.domain.gateways;

import com.mrlopito.senai.exam.crud.domain.response.ViaCepResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "viacep-service-base-url")
public interface ViaCepGateway {

    @GET
    @Path("/{cep}/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ViaCepResponse retrieveAddress(@PathParam("cep") String cep);
}
