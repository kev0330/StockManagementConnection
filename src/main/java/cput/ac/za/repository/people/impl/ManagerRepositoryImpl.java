package cput.ac.za.repository.people.impl;

import cput.ac.za.domain.people.Manager;
import cput.ac.za.repository.people.ManagerRepository;

import java.util.HashSet;
import java.util.Set;

public class ManagerRepositoryImpl implements ManagerRepository {
    private Set<Manager> db;
    private static ManagerRepository repository = null;

    private ManagerRepositoryImpl() {
        this.db = new HashSet<>();
    }

    private Manager find(String manager) {
        return this.db.stream()
                .filter(id -> id.getId().equals(manager))
                .findAny()
                .orElse(null);
    }

    public static ManagerRepository getRepository(){
        if(repository == null) repository = new ManagerRepositoryImpl();
        return repository;
    }

    public Manager create(Manager manager){
        this.db.add(manager);
        return manager;
    }

    public Manager read(final String id){
        Manager find = find(id);
        return find;
    }

    public void delete(String id) {
        Manager find = find(id);
        if(find != null) this.db.remove(find);
    }

    public Manager update(Manager manager) {
        Manager delete = find(manager.getId());
        if(delete != null){
            this.db.remove(delete);
            return create(manager);
        }
        return manager;
    }

    public Set<Manager> getAll(){
        return this.db;
    }
}
