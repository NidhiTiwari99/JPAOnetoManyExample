package mypackage.service;
import mypackage.model.*;
import mypackage.repository.ProductRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository prodrepo;
	
	public Product AddProduct(Product pd) {
		Product p=prodrepo.save(pd);
		return p;
	}
	public Product UpdateProduct(Product pd) {
		Product p=prodrepo.save(pd);
		return p;
	}
	public List<Product>GetProducts(){
		return prodrepo.findAll();
	}
	public Product GetProduct(int id) {
		return prodrepo.findById(id).get();
	}
	public Product DeleteProduct(int id) {
		Product pd =GetProduct(id);
		prodrepo.delete(pd);
		return pd;
	}
	
	}
