package cput.ac.za.repository.people.impl;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.repository.people.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Set<Employee> db;
    private static EmployeeRepository repository = null;

    private EmployeeRepositoryImpl() {
        this.db = new HashSet<>();
    }

    private Employee find(String employee) {
        return this.db.stream()
                .filter(id -> id.getId().equals(employee))
                .findAny()
                .orElse(null);
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.db.add(employee);
        return employee;
    }

    public Employee read(final String id){
        Employee find = find(id);
        return find;
    }

    public void delete(String id) {
        Employee find = find(id);
        if(find != null) this.db.remove(find);
    }

    public Employee update(Employee employee) {
        Employee delete = find(employee.getId());
        if(delete != null){
            this.db.remove(delete);
            return create(employee);
        }
        return employee;
    }

    public Set<Employee> getAll(){
        return this.db;
    }
}
