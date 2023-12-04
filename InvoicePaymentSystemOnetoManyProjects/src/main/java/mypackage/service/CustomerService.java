package mypackage.service;
import mypackage.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mypackage.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository cusrepo;
	
	public Customer AddCustomer(Customer cs) {
		Customer c=cusrepo.save(cs);
		return c;
	}
	public Customer UpdateCustomer(Customer cs) {
		Customer c=cusrepo.save(cs);
		return c;
	}
	public List<Customer>GetCustomers(){
		return cusrepo.findAll();
	}
	public Customer GetCustomer(int id) {
		return cusrepo.findById(id).get();
	}
	public Customer DeleteCustomer(int id) {
		Customer cs =GetCustomer(id);
		cusrepo.delete(cs);
		return cs;
	}

}
