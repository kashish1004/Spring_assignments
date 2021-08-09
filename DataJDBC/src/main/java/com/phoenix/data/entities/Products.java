package com.phoenix.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */

public class Products implements Persistable<Integer> {
	
	@Id
	private int id;
	private String name;
	private String brand;
	private float price;
	
	@Transient
	private boolean isInsert;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}
	
	public Products(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
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
	public void setInsert(boolean isInsert) {
		this.isInsert = isInsert;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	//persistable methods implemented
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isInsert;
	}

	
	
}