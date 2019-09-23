package cput.ac.za.service.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
