package com.phoenix.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.phoenix.data.entities.Products;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 * @description DAO interface or Repository Interface
 */
public interface ProductRepository extends CrudRepository<Products, Integer> {
	
}
