package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Customer;

public class CustomerFactory {
    public static Customer getCustomer(String id, String name, String surname){
        return new Customer.Builder().id(id).name(name).surname(surname).build();
    }
}
