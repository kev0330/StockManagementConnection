package cput.ac.za.repository.people;

import cput.ac.za.domain.people.Manager;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface ManagerRepository extends IRepository<Manager, String> {
    Set<Manager> getAll();
}
