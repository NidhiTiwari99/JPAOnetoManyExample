package mypackage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.*;
import mypackage.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class CustomerApiController {
	
	@Autowired
	CustomerService cusservice;
	
	@PostMapping("api/customer")
	public Customer Add(@RequestBody Customer cs) {
		return cusservice.AddCustomer(cs);
	}
	@PutMapping("api/customer")
	public Customer Update(@RequestBody Customer cs) {
		return cusservice.UpdateCustomer(cs);
	}
	@DeleteMapping("api/customer/{id}")
	public Customer Delete(@PathVariable("id") int id) {
		return cusservice.DeleteCustomer(id);
	}
	@GetMapping("api/customer")
	public List<Customer> GetAll(){
		return cusservice.GetCustomers();
	}
	@GetMapping("api/customer/{id}")
	public Customer GetById(@PathVariable("id") int id) {
		return cusservice.GetCustomer(id);
	}


}
