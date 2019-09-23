package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface CustomerRepository extends IRepository<Customer, String> {
    Set<Customer> getAll();
}
