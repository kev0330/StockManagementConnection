package cput.ac.za.factory;

import cput.ac.za.domain.people.Administrator;
import cput.ac.za.factory.people.AdministratorFactory;
import org.junit.Assert;
import org.junit.Test;

public class AdministratorFactoryTest {

    @Test
    public void getAdministrator() {

        Administrator administrator = AdministratorFactory.getAdministrator( "123", "Name", "Surname", "Email");
        Assert.assertNotNull(administrator);
    }
}
