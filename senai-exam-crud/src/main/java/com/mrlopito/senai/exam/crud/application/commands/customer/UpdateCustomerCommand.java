package com.mrlopito.senai.exam.crud.application.commands.customer;

import com.mrlopito.senai.exam.crud.domain.dtos.CreateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.dtos.UpdateCustomerDTO;
import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import com.mrlopito.senai.exam.crud.domain.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UpdateCustomerCommand {

    @Inject
    private CustomerRepository repository;


    @Transactional
    public void handle(UpdateCustomerDTO dto, Long id) {
        Customer customer = new Customer(dto.getName(), dto.getEmail(), dto.getDocument(), dto.getAddress());

        repository.update(customer, id);

    }
}
