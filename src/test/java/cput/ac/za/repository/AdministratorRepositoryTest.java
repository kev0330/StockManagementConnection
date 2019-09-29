package cput.ac.za.repository;

import cput.ac.za.domain.people.Administrator;
import cput.ac.za.factory.people.AdministratorFactory;
import cput.ac.za.repository.people.impl.AdministratorRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorRepositoryTest {

    @Autowired
    private AdministratorRepositoryImpl administratorRepository;
    Administrator administrator = AdministratorFactory.getAdministrator("123", "Name", "Surname", "Email");

    @Test
    public void a_create() {
        administratorRepository.create(administrator);
        assertNotNull(administratorRepository.getAll());
        System.out.println(administratorRepository.getAll());

    }

    @Test
    public void b_read() {
        Administrator fromSet = administratorRepository.read(administrator.getUserID());
        assertEquals(administrator, fromSet);
        System.out.println(administratorRepository.getAll());
    }

    @Test
    public void c_update() {
        Administrator updatedAdministrator  = AdministratorFactory.getAdministrator("123", "UpdateName", "Surname", "Email");
        administratorRepository.update(updatedAdministrator);
        Assert.assertNotEquals(administrator.getFirstName(), updatedAdministrator.getFirstName());
        System.out.println(administratorRepository.getAll());
    }

    @Test
    public void d_delete() {
        assertNotNull(administratorRepository.getAll());
        administratorRepository.delete(administrator.getUserID());
        Administrator administratorTor = administratorRepository.read(administrator.getUserID());
        assertNull(administratorTor);
        System.out.println(administratorRepository.getAll());
    }
}