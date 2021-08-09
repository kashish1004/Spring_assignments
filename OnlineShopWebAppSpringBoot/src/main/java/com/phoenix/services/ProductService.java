package com.phoenix.services;

import java.util.List;

import com.phoenix.entities.Product;
import com.phoenix.exceptions.ProductNotFoundException;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */

public interface ProductService {
	Product findById(int id) throws ProductNotFoundException;
	List<Product> getAllProducts();
	void add(Product pro);
	void edit(Product pro);
	void remove(Product pro);
	List<Product> sortByName(List<Product> product);
	List<Product> sortByBrand(List<Product> product);
	List<Product> sortByPrice(List<Product> product);
	List<Product> sortByPriceDesc(List<Product> product);
}
