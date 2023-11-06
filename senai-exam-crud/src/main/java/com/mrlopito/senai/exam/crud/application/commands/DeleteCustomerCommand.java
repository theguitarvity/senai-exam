package com.mrlopito.senai.exam.crud.application.commands;

import com.mrlopito.senai.exam.crud.domain.dtos.CreateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import com.mrlopito.senai.exam.crud.domain.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DeleteCustomerCommand {
    @Inject
    private CustomerRepository repository;


    @Transactional
    public void handle(Long id) {

        repository.delete(id);

    }
}
