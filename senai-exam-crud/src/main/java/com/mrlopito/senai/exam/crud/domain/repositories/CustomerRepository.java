package com.mrlopito.senai.exam.crud.domain.repositories;

import com.mrlopito.senai.exam.crud.domain.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    public void create(Customer customer);
    public Customer update(Customer customer, Long id);
    public void delete(Long id);
    public Customer get(Long id);
    public List<Customer> getAll();
}
