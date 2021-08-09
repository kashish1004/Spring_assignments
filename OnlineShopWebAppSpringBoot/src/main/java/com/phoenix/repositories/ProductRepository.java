package com.phoenix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.Product;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> OrderByName();
	List<Product> OrderByBrand();
	List<Product> OrderByPrice();
	List<Product> OrderByPriceDesc();
}
