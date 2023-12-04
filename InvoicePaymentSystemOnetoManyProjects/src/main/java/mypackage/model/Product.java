package mypackage.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tblproducts")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private int purchase_price;
	private int selling_price;
	private int tax;
	private int stock_quantity;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("product")
	@JsonIgnore
	private Set<InvoiceProducts> invoiceproducts;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, String product_name, int purchase_price, int selling_price, int tax,
			int stock_quantity, Set<InvoiceProducts> invoiceproducts) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.purchase_price = purchase_price;
		this.selling_price = selling_price;
		this.tax = tax;
		this.stock_quantity = stock_quantity;
		this.invoiceproducts = invoiceproducts;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getpurchase_price() {
		return purchase_price;
	}

	public void setpurchase_price(int product_price) {
		this.purchase_price = product_price;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public Set<InvoiceProducts> getInvoiceproducts() {
		return invoiceproducts;
	}

	public void setInvoiceproducts(Set<InvoiceProducts> invoiceproducts) {
		this.invoiceproducts = invoiceproducts;
	}

}
