package com.phoenix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.entities.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.repositories.ProductRepository;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 02-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository proRepo;
	
	@Override
	public Product findById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return proRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry Product with id "+ id+ " is not found"));
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public void add(Product pro){
		// TODO Auto-generated method stub
		proRepo.save(pro);
	}

	@Override
	public void edit(Product pro) {
		// TODO Auto-generated method stub
		Optional<Product> op = proRepo.findById(pro.getId());
		if(op.isPresent()) {
			proRepo.save(pro);
		}
		else {
			System.out.println("Sorry Product Not Found");
		}
	}

	@Override
	public void remove(Product pro) {
		// TODO Auto-generated method stub
		Optional<Product> op = proRepo.findById(pro.getId());
		if(op.isPresent()) {
			proRepo.delete(pro);
		}
		else {
			System.out.println("Sorry Product Not Found");
		}
	}

	@Override
	public List<Product> sortByName(List<Product> product) {
		// TODO Auto-generated method stub
		return proRepo.OrderByName();
	}

	@Override
	public List<Product> sortByBrand(List<Product> product) {
		// TODO Auto-generated method stub
		return proRepo.OrderByBrand();
	}

	@Override
	public List<Product> sortByPrice(List<Product> product) {
		// TODO Auto-generated method stub
		return proRepo.OrderByPrice();
	}

	@Override
	public List<Product> sortByPriceDesc(List<Product> product) {
		// TODO Auto-generated method stub
		return proRepo.OrderByPriceDesc();
	}

	

}
