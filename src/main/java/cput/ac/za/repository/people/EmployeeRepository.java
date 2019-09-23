package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.repository.IRepository;

import java.util.Set;

    public interface EmployeeRepository extends IRepository<Employee, String> {
        Set<Employee> getAll();
    }

