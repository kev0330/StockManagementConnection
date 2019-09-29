package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Administrator;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface AdministratorRepository extends IRepository<Administrator, String> {

    Set<Administrator> getAll();

}
