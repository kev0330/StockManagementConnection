package cput.ac.za.service.people;

import cput.ac.za.domain.people.Manager;
import cput.ac.za.service.IService;

import java.util.Set;

public interface ManagerService extends IService<Manager, String> {
    Set<Manager> getAll();
}

