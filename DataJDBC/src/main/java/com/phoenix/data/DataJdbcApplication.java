package com.phoenix.data;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Products;
import com.phoenix.data.repositories.ProductRepository;



@SpringBootApplication
public class DataJdbcApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger();
	
	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//get all products
		Iterable<Products> products = productRepo.findAll();
		//products.forEach(System.out::println);
		products.forEach(product->LOG.info(product));
		
		
		LOG.info("============================");
		LOG.info("============================");
		/*//get product by Id
		Optional<Products> op = productRepo.findById(108);
		if(op.isPresent()) {
			Products p = op.get();
			LOG.debug("Product :"+ p);
		}
		else {
			LOG.error("Sorry! Product Not Found");
		}
		
		LOG.info("============================");
		LOG.info("============================");
		
		LOG.info("No of products: "+ productRepo.count());
		
		//update product by changing price
		op = productRepo.findById(108);
		if(op.isPresent()) {
			Products p = op.get();
			float oldPrice = p.getPrice();
			p.setPrice(p.getPrice()+1000.0f);
			productRepo.save(p);
			LOG.info("Product :"+ p.getId()+" updated successfully");
			float newPrice = p.getPrice();
			LOG.info("Old Price: "+oldPrice);
			LOG.info("New Price: "+newPrice);
		}
		else {
			LOG.error("Sorry! Product Not Found");
		}
		
		LOG.info("============================");
		LOG.info("============================");
		
		//delete product
		op = productRepo.findById(108);
		if(op.isPresent()) {
			Products p = op.get();
			productRepo.delete(p);
			LOG.info("Product :"+ p.getId()+" deleted successfully");
		}
		else {
			LOG.error("Sorry! Product Not Found");
		}
		
		LOG.info("============================");
		LOG.info("============================");
		
		//insert new product
		Products p1 = new Products();
		p1.setId(1234);
		p1.setBrand("JBL");
		p1.setName("Home Theatre");
		p1.setPrice(64000.0f);
		p1.setInsert(true); //as save method is used for update and insert so to use the insert property do this
		productRepo.save(p1); 
		LOG.info("New Product :"+ p1.getId()+" inserted successfully");
	*/
		List<Products> pByNm = productRepo.findByName("Air Conditioner");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByName("Laptop");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByBrand("OnePlus");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByPrice(50000.0f);
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByPriceBetween(10000.0f,55000.0f);
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByNameAndBrand("Laptop","HP");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByNameAndPrice("Phone",18000.0f);
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByBrandAndPrice("OnePlus",50000.0f);
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByNameLike("L%");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByNameOrderByPrice("Phone");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.findByNameOrderByPriceDesc("Phone");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.OrderByBrand();
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.sortByName();
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		pByNm = productRepo.getProductsByNameAndPrice("Phone", 50000.0f);
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("============================");
		LOG.info("============================");
		
		LOG.info("No. of rows Affected:" +productRepo.updatePriceByBrand("Poco", 500.0f));
		
		LOG.info("============================");
		LOG.info("============================");
		
		LOG.info("Product deleted:" +productRepo.deleteProductById(116));
		
	}
}
