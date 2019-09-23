package cput.ac.za.controller;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.factory.people.CustomerFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerController {

    @Autowired
    private TestRestTemplate restTemplate;
    private String url = "http://localhost:8080/customer";

    @Test
    public void a_create(){
        Customer customer = CustomerFactory.getCustomer("123","Kevin","Yang");

        ResponseEntity<Customer> response = restTemplate.postForEntity(url + "/new", customer, Customer.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void b_findId(){
        Customer c = restTemplate.getForObject(url + "/find/" + "123", Customer.class);
        Assert.assertNotNull(c);
        System.out.println(c.getName());
    }

    @Test
    public void c_update(){

        Customer c = restTemplate.getForObject(url + "/find/" + "123", Customer.class);
        restTemplate.put(url + "/update/" + "123", c);
        Customer update = restTemplate.getForObject(url + "/update/" + "123", Customer.class);
        Assert.assertNotNull(c);
        System.out.println(update);
        System.out.println(c);
    }

    @Test
    public void e_delete(){

        Customer c = restTemplate.getForObject(url + "/find/" + "123", Customer.class);
        Assert.assertNotNull(c);
        restTemplate.delete(url + "/delete/" + "123");

        try{
            c = restTemplate.getForObject(url + "/find/" + "123", Customer.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void d_getAll(){

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + "/getall", HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }


}
