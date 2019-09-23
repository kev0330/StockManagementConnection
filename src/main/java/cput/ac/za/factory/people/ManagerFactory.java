package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Manager;

public class ManagerFactory {
    public static Manager getManager(String id, String name, String surname){
        return new Manager.Builder().id(id).name(name).surname(surname).build();
    }
}
