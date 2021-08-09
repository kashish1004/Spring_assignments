package com.phoenix.models;

/* 
* @author kashish.jain@stltech.in
* Creation Date 4-Aug-2021
* Version - 1.0
* Copyright - Sterlite Technologies Ltd.
* @description Model class- Java Bean
*/

public class CartItem {
	
	private int id;
	private String name;
	private String brand;
	private float price;
	
	private int quantity;
	private double itemValue;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int id, String name, String brand, float price, int quantity, double itemValue) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.itemValue = itemValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", quantity="
				+ quantity + ", itemValue=" + itemValue + "]";
	}
}
