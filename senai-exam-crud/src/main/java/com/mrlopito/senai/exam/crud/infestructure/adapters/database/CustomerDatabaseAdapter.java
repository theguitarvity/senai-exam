package com.mrlopito.senai.exam.crud.infestructure.adapters.database;

import com.mrlopito.senai.exam.crud.domain.entities.Customer;
import com.mrlopito.senai.exam.crud.domain.repositories.CustomerRepository;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.List;

@Singleton
public class CustomerDatabaseAdapter implements CustomerRepository {
    @Override
    @Transactional
    public void create(Customer customer) {
        Customer.persist(customer);
    }

    @Override
    @Transactional
    public Customer update(Customer customer, Long id) {
        Customer customerToUpdate = Customer.findById(id);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setDocument(customer.getDocument());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setAddress(customer.getAddress());

        return customerToUpdate;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Customer customerToDelete = Customer.findById(id);

        customerToDelete.delete();
    }

    @Override
    public Customer get(Long id) {
        return Customer.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return Customer.listAll();
    }
}
