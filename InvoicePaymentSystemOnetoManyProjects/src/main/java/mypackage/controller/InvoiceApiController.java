package mypackage.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.*;

import mypackage.service.InvoiceService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class InvoiceApiController {
	
	@Autowired
	
	InvoiceService invoiceservice;
	
	@PostMapping("api/newinvoice")
	public InvoiceDetails NewInvoice(@RequestBody InvoiceDetails d) {
		System.out.println(d.getInvoice_date()+" "+d.getCustomer().getCustomer_id()+" "+d.getTotal_amount());
		for(InvoiceProducts p:d.getInvoiceproducts()) {
			System.out.println(p.getProduct().getProduct_id()+" "+p.getQuantity());
		}
		InvoiceDetails dc=invoiceservice.GenrateInvoice(d);
		return dc;
		//return invoiceservice.GenrateInvoice(d);
	}

	@GetMapping("api/invoice")
	public List<InvoiceModel>GetInvoices(){
		return invoiceservice.GetInvoices();
	}
	@GetMapping("api/invoice/{id}")
	public InvoiceModel GetInvoice(@PathVariable("id") int id){
		return invoiceservice.GetInvoice(id);
	}
	
	@PostMapping("api/payinvoice")
	public InvoicePayments AddPayment(@RequestBody InvoicePayments p) {
		return invoiceservice.AddPayment(p);
	}
}
