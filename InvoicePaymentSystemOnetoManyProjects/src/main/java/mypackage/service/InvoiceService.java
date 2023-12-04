package mypackage.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


import mypackage.model.*;
import mypackage.repository.InvoiceDetailsRepository;
import mypackage.repository.InvoicePaymentsRepository;
import mypackage.repository.InvoiceProductsRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceDetailsRepository indetailrepo;
	@Autowired
	InvoicePaymentsRepository inpaymentrepo;
	@Autowired
	InvoiceProductsRepository inproductrepo;

public InvoiceDetails GenrateInvoice(InvoiceDetails d) {
	InvoiceDetails id=new InvoiceDetails(0, d.getInvoice_date(), d.getCustomer(), d.getTotal_amount(), null, null);
	InvoiceDetails invoice =indetailrepo.save(id);
	for(InvoiceProducts p:d.getInvoiceproducts()) {
		InvoiceProducts pr=new InvoiceProducts(0, invoice, p.getProduct(), p.getQuantity());
		inproductrepo.save(pr);
	}
	return invoice;
}
public List<InvoiceModel>GetInvoices(){
	List<InvoiceModel>lst=new ArrayList<InvoiceModel>();
	for(InvoiceDetails d:indetailrepo.findAll()) {
		float paid_amount=0;
		for(InvoicePayments p:d.getInvoicepayments()){
			if(p.getInvoicedetails().getInvoice_id()==d.getInvoice_id()) {
				paid_amount+=p.getPayment_amount();
			}
		}
		float total_amount=d.getTotal_amount();
		float remaining_amount=total_amount-paid_amount;
		String status="";
		if(remaining_amount==0) {
			status="Paid";
		}
		else if (paid_amount==0) {
			status="Un Paid";
		}
		else if(paid_amount>0 && paid_amount<total_amount) {
			status="Partial Paid";
		}
	InvoiceModel im=new InvoiceModel(d.getInvoice_id(), d.getInvoice_date(), d.getCustomer().getCustomer_id(), d.getCustomer().getCustomer_name(),total_amount, paid_amount, remaining_amount, status);
	lst.add(im);
	}
	return lst;
}

public InvoiceModel GetInvoice(int id){
	InvoiceModel im=null;
	for(InvoiceModel d:GetInvoices())
		if(d.getInvoice_id()==id) {
	im=d;
	break;
		}
	return im;
}

public InvoicePayments AddPayment(InvoicePayments p) {
	InvoicePayments pm=new InvoicePayments(0, p.getInvoicedetails(), p.getPayment_date(), p.getPayment_amount(), p.getPayment_mode(), p.getDescription());
	return inpaymentrepo.save(pm);
}

}
