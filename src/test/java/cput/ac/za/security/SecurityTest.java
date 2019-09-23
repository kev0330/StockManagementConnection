package cput.ac.za.security;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.factory.people.CustomerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/administrator";

    @Autowired

    @Before
    public void addDummyData(){

        Customer c = CustomerFactory.getCustomer("123","kevin", "yang");

        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/new", c, Customer.class);

    }

    @Test
    public void whenCorrect() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void whenIncorrect() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admins").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }
}
