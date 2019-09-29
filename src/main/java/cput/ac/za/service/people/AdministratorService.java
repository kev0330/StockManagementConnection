package cput.ac.za.service.people;

import cput.ac.za.domain.people.Administrator;
import cput.ac.za.service.IService;

import java.util.Set;

public interface AdministratorService extends IService<Administrator, String> {

    Set<Administrator> getAll();

}
