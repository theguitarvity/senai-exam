package com.mrlopito.senai.exam.crud.application.commands.customer;


import com.mrlopito.senai.exam.crud.domain.dtos.CreateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import com.mrlopito.senai.exam.crud.domain.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RetrieveAllCustomersCommand {

    @Inject
    private CustomerRepository repository;


    @Transactional
    public List<Customer> handle() {

        return repository.getAll();

    }
}
