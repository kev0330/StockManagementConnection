package cput.ac.za.service.people.impl;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.repository.people.CustomerRepository;
import cput.ac.za.repository.people.impl.CustomerRepositoryImpl;
import cput.ac.za.service.people.CustomerService;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("CustomerServiceImpl")
public class CustomerServiceImpl implements  CustomerService{
    private CustomerRepository repository;
    private static CustomerService userService = null;

    private CustomerServiceImpl() {
        this.repository = CustomerRepositoryImpl.getRepository();
    }

    public static CustomerService getService() {
        if (userService == null) userService = new CustomerServiceImpl();
        return userService;
    }

    @Override
    public Customer create(Customer d) {
        return this.repository.create(d);
    }

    @Override
    public Customer read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Customer update(Customer d) {
        return this.repository.update(d);
    }

    @Override
    public void delete(String d) {
        this.repository.delete(d);
    }

    @Override
    public Set<Customer> getAll() {
        return this.repository.getAll();
    }
}
