package com.mrlopito.senai.exam.crud.application.commands.customer;


import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import com.mrlopito.senai.exam.crud.domain.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RetrieveCustomerByIdCommand {

    @Inject
    private CustomerRepository repository;


    @Transactional
    public Customer handle(Long id) {

        return repository.get(id);

    }
}
