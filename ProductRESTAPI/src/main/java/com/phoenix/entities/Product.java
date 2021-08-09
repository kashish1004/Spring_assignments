package com.phoenix.entities;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 30-jul-2021
 * @copyright Sterlite Techonologies Ltd.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(generator = "increment")
	private int id;
	private String name;
	private String brand;
	private float price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
}
