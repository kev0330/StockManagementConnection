package cput.ac.za.service.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.service.IService;

import java.util.Set;

public interface CustomerService extends IService<Customer, String> {
    Set<Customer> getAll();
}
