package com.phoenix.data;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger();
	
	@Autowired
	private ProductRepository proRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//count of products
		LOG.info("No. of products: "+  proRepo.count());
		
		LOG.info("===========================");
		LOG.info("===========================");

		List<Product> product = proRepo.findAll();
		product.forEach(produ -> LOG.info(produ));

		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByName("Phone");
		product.forEach(produ -> LOG.info(produ));

		/*
		 * Product p = new Product(); p.setBrand("UHD TV"); p.setName("LG");
		 * p.setPrice(53000.0f); p = proRepo.save(p); LOG.info("New product " +
		 * p.getId() + " added successfully");
		 */
		 
		List<Product> pro = proRepo.getProductsByNameAndPrice("Phone", 50000.0f);
		pro.forEach(prod->LOG.info(pro));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByBrand("Samsung");
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByPrice(50000.0f);
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByPriceBetween(10000.0f,60000.0f);
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByNameAndBrand("Phone","OnePlus");
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByNameAndPrice("Phone",18000.0f);
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByBrandAndPrice("OnePlus",50000.0f);
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByNameLike("P%");
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByNameOrderByPrice("Phone");
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.findByNameOrderByPriceDesc("Phone");
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");

		product = proRepo.OrderByBrand();
		product.forEach(produ -> LOG.info(produ));
		
		LOG.info("===========================");
		LOG.info("===========================");
		LOG.info("No. of rows affected: " + proRepo.updatePriceByBrand("Samsung", 100.0f));
		
		LOG.info("===========================");
		LOG.info("===========================");
		LOG.info("Product deleted:" +proRepo.deleteProductById(1240));
		
	}

}
