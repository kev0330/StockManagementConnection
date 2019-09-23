package cput.ac.za.service.people.impl;

import cput.ac.za.domain.people.Manager;
import cput.ac.za.repository.people.ManagerRepository;
import cput.ac.za.repository.people.impl.ManagerRepositoryImpl;
import cput.ac.za.service.people.ManagerService;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("ManagementServiceImpl")
public class ManagerServiceImpl implements ManagerService{
    private ManagerRepository repository;
    private static ManagerService userService = null;

    private ManagerServiceImpl() {
        this.repository = ManagerRepositoryImpl.getRepository();
    }

    public static ManagerService getService() {
        if (userService == null) userService = new ManagerServiceImpl();
        return userService;
    }

    @Override
    public Manager create(Manager d) {
        return this.repository.create(d);
    }

    @Override
    public Manager read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Manager update(Manager d) {
        return this.repository.update(d);
    }

    @Override
    public void delete(String d) {
        this.repository.delete(d);
    }

    @Override
    public Set<Manager> getAll() {
        return this.repository.getAll();
    }
}
