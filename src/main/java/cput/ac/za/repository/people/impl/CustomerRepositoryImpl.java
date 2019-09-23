package cput.ac.za.repository.people.impl;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.repository.people.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("CustomerInMemory")
public class CustomerRepositoryImpl implements CustomerRepository {

    private Set<Customer> db;
    private static CustomerRepository repository = null;

    private CustomerRepositoryImpl() {
        this.db = new HashSet<>();
    }

    private Customer find(String customer) {
        return this.db.stream()
                .filter(id -> id.getId().equals(customer))
                .findAny()
                .orElse(null);
    }

    public static CustomerRepository getRepository(){
        if(repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    public Customer create(Customer customer){
        this.db.add(customer);
        return customer;
    }

    public Customer read(final String id){
        Customer find = find(id);
        return find;
    }

    public void delete(String id) {
        Customer find = find(id);
        if(find != null) this.db.remove(find);
    }

    public Customer update(Customer customer) {
        Customer delete = find(customer.getId());
        if(delete != null){
            this.db.remove(delete);
            return create(customer);
        }
        return customer;
    }

    public Set<Customer> getAll(){
        return this.db;
    }
}
