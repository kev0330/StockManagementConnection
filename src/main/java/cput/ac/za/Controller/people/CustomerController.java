package cput.ac.za.Controller.people;

import cput.ac.za.domain.people.Customer;
import cput.ac.za.service.people.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerServiceImpl service;

    @PostMapping("/new")
    public Customer create(@RequestBody Customer c){
        return service.create(c);
    }

    @GetMapping(path = "/find/{id}")
    public Customer findId(@PathVariable String id){

        Customer c = service.read(id);
        return c;
    }

    @PutMapping("/update")
    public void update(@RequestBody Customer c){
        service.update(c);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<Customer> getAll(){
        return service.getAll();
    }
}
