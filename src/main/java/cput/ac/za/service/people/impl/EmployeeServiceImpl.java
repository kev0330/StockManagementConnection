package cput.ac.za.service.people.impl;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.repository.people.EmployeeRepository;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import cput.ac.za.service.people.EmployeeService;
import org.springframework.stereotype.Repository;

import java.util.Set;


public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    private static EmployeeService userService = null;

    private EmployeeServiceImpl() {
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeService getService() {
        if (userService == null) userService = new EmployeeServiceImpl();
        return userService;
    }

    @Override
    public Employee create(Employee d) {
        return this.repository.create(d);
    }

    @Override
    public Employee read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Employee update(Employee d) {
        return this.repository.update(d);
    }

    @Override
    public void delete(String d) {
        this.repository.delete(d);
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }
}
