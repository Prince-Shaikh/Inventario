package com.inventoryManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {

	private int id;
	private Date date;
	private Vendor vendor;
	private Customer customer;
	private String name;
	ArrayList<InvoiceItem> items;
	
	
	
	public Invoice(int id, Date date, Vendor vendor, ArrayList<InvoiceItem> items) {
		
		this.id = id;
		this.date = date;
		this.vendor = vendor;
		this.items = items;
		this.name = vendor.getName();
		
	}
	public Invoice(int id, Date date, Customer customer, ArrayList<InvoiceItem> items) {
		
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.items = items;
		this.name = customer.getName();
		
	}
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public double getTotal() {
		double total = 0;
		
		for(InvoiceItem item : this.items) {
			total += item.getTotal();
		}
		
		return total;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor v) {
		this.vendor = v;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer c) {
		this.customer = c;
	}
	
	public ArrayList<InvoiceItem> getInvoiceData(){
		return this.items;
	}
	
	public void setInvoiceData(ArrayList<InvoiceItem> items) {
		this.items = items;
	}
	
}
