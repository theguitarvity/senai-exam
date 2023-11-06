package com.mrlopito.senai.exam.crud.application.commands.customer;

import com.mrlopito.senai.exam.crud.domain.gateways.ViaCepGateway;
import com.mrlopito.senai.exam.crud.domain.response.ViaCepResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@ApplicationScoped
public class RetrieveAddressInformationCommand {


    final ViaCepGateway gateway;


    @Inject
    public RetrieveAddressInformationCommand(@RestClient ViaCepGateway gateway) {
        this.gateway = gateway;
    }

    public ViaCepResponse handle(String cep){
        return this.gateway.retrieveAddress(cep);
    }
}
