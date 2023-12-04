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
import mypackage.service.ProductService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class ProductApiController {

	@Autowired
	ProductService prodservice;
	
	@PostMapping("api/product")
	public Product Add(@RequestBody Product pd) {
		return prodservice.AddProduct(pd);
	}
	@PutMapping("api/product")
	public Product Update(@RequestBody Product pd) {
		return prodservice.UpdateProduct(pd);
	}
	@DeleteMapping("api/product/{id}")
	public Product Delete(@PathVariable("id") int id) {
		return prodservice.DeleteProduct(id);
	}
	@GetMapping("api/product")
	public List<Product> GetAll(){
		return prodservice.GetProducts();
	}
	@GetMapping("api/product/{id}")
	public Product GetById(@PathVariable("id") int id) {
		return prodservice.GetProduct(id);
	}

}
