package com.mrlopito.senai.exam.crud.resources;


import com.mrlopito.senai.exam.crud.application.commands.customer.RetrieveAddressInformationCommand;
import com.mrlopito.senai.exam.crud.domain.response.ViaCepResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/viacep")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ViaCepResource {
    private final RetrieveAddressInformationCommand retrieveAddressInformationCommand;


    @Inject
    public ViaCepResource(RetrieveAddressInformationCommand retrieveAddressInformationCommand) {
        this.retrieveAddressInformationCommand = retrieveAddressInformationCommand;
    }

    @GET
    @Path("{cep}")
    public Response retrieveAddressInformation(String cep) {
        ViaCepResponse response = retrieveAddressInformationCommand.handle(cep);

        return Response.ok(response).build();
    }

}
