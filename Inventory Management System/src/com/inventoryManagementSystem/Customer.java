package com.inventoryManagementSystem;

public class Customer {

	private int ID;
	private static int idCournter = 0;
	private String name;
	private String address;
	private String phone;
	
	
	public Customer(String name, String address, String number) {
		this.name = name;
		this.address = address;
		this.phone = number;
		
		idCournter++;
		ID = idCournter;
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

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}
	public String getPhoneNumber() {
		return phone;
	}
}
