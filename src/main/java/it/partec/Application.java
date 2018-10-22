package it.partec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.partec.dao.CustomerRepository;
import it.partec.model.Customer;

import javax.sql.DataSource;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    CustomerRepository repository;
   
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

  //  @Transactional(readOnly = false)
    public void run(String... args) throws Exception {
    	System.out.println("Our DataSource is = " + dataSource);
    	getCustomers();
    }	
		
	void getCustomers() {
		Iterable<Customer>  customerlist = repository.findAll();
		for(Customer customer:customerlist){
		System.out.println("Here is a system: " + customer.toString());
		}
	}

}
