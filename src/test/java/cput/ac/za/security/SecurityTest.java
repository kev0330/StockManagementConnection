package cput.ac.za.security;

import cput.ac.za.domain.people.Administrator;
import cput.ac.za.factory.people.AdministratorFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/administrator";

    @Autowired
    @Before
    public void addDummyData(){
        Administrator person = AdministratorFactory.getAdministrator("123", "Name", "Surname", "Email");
        ResponseEntity<Administrator> postResponse = restTemplate.postForEntity(baseURL + "/new", person, Administrator.class);
    }

    @Test
    public void whenCorrectCredentialsWillBe200() throws Exception {
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/getall", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void whenIncorrectCredentialsWill() throws Exception {
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "wrongPassword").getForEntity(baseURL + "/getall", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
