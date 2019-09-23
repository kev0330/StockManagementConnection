package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Employee;

public class EmployeeFactory {
    public static Employee getEmployee(String id, String name, String surname){
        return new Employee.Builder().id(id).name(name).surname(surname).build();
    }
}
