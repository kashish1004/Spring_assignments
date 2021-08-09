package com.phoenix.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Products;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class DataJdbGradleApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DataJdbGradleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//get all products
		Iterable<Products> products = productRepo.findAll();
		products.forEach(System.out::println);
		
	}

}
