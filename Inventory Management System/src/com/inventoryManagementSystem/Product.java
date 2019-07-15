package com.inventoryManagementSystem;

public class Product {

	private int ID;
	private static int idCournter = 0;
	private String name;
	private String discription;
	private double price;
	private int qty;
	
	
	public Product(String name, String discription, double price) {
		this.name = name;
		this.discription = discription;
		this.price = price;
		
		idCournter++;
		ID = idCournter;
	}
	
	public int getQuantity() {
		return qty;
	}
	public void setQuantity(int num) {
		this.qty = num;
	}
	public static int getidCount() {
		return idCournter;
	}
	public int getID() {
		return ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDiscription() {
		return discription;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
}
