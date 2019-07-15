package com.inventoryManagementSystem;

public class InvoiceItem {

	private int sno;
	private Product product;
	private int qty;
	private double total;
	private double price;
	
	public InvoiceItem(int sno, Product product,int qty, double price, double total) {
		this.sno = sno;
		this.product = product;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int num) {
		this.sno = num;
	}
	
	public Product getProduct() {
		return this.product;
	}
	public void SetProduct(Product p) {
		this.product = p;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double num) {
		total = num;
	}
	
	public int getQuantity() {
		return qty;
	}
	public void setQuantity(int num) {
		qty = num;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
