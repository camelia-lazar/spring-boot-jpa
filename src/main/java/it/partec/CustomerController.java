package it.partec;

import org.springframework.web.bind.annotation.RestController;

import it.partec.dao.CustomerRepository;
import it.partec.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CustomerController {

	 @Autowired
	    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String index() {
        return "Ciao a tutti!";
    }
    
    @RequestMapping("/all")
    public List<Customer> findAll() {
    	
		return (List<Customer>) customerRepository.findAll();
    }

}
