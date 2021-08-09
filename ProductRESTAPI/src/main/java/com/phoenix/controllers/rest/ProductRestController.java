package com.phoenix.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phoenix.entities.Product;
import com.phoenix.repositories.ProductRepository;

/* 
* @author kashish.jain@stltech.in
* Creation Date 2-Aug-2021
* Version - 1.0
* Copyright - Sterlite Technologies Ltd.
* @description RESTful Web Service for product Resource using 
* 			   Spring Web MVC
*/

@RequestMapping("/products")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductRepository proRepo;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return proRepo.findAll();
	}
	
	@GetMapping("/{pid}")
	public Object getById(@PathVariable("pid") int id) {
		Optional<Product> op = proRepo.findById(id);
		if(op.isPresent())
			return proRepo.findById(id).get();
		else
			return "Sorry! product not found";
	}
	
	//inserts new product if new id or update existing product
	@PutMapping
	public String addProduct(@RequestBody Product pro) {
		pro = proRepo.save(pro);
		return "New Product "+pro.getId()+" is saved added successfully";
	}
	
	//update existing product
	@PostMapping
	public String updateProduct(@RequestBody Product pro) {
		Optional<Product> op = proRepo.findById(pro.getId());
		if(op.isPresent()) {
			pro = proRepo.save(pro);
			return "Product "+pro.getId()+" is Updated successfully";
		}
		else
			return "Sorry! Product is not found";
	}
	
	@DeleteMapping
	public String deleteProduct(@RequestBody Product pro) {
		Optional<Product> op = proRepo.findById(pro.getId());
		if(op.isPresent()) {
			proRepo.delete(pro);
			return "Product "+pro.getId()+" is Deleted successfully";
		}
		else
			return "Sorry! Product is not found";
	}
	
	@PostMapping("/add-form")
	public RedirectView addFormData(@RequestParam("nm") String name,@RequestParam("brand") String brand,@RequestParam("price") float price) {
		Product p = new Product();
		p.setBrand(brand);
		p.setName(name);
		p.setPrice(price);
		p = proRepo.save(p);
		//return "Form data with product "+p.getId()+ " is added successfully";
		//return "redirect:/success";
		return new RedirectView("success");
	}
	
	@GetMapping("/{nm}/{br}")
	public List<Product> getProductByNameAndBrand(@PathVariable("nm") String name,@PathVariable("br") String brand){
		return proRepo.findByNameAndBrand(name, brand);
	}
	
	@GetMapping("/name/{nm}")
	public List<Product> getProductByName(@PathVariable("nm") String name){
		return proRepo.findByName(name);
	}
	
	@GetMapping("/{nm}/{pr}")
	public List<Product> getProductByNameAndPrice(@PathVariable("nm") String name,@PathVariable("pr") float price){
		return proRepo.findByNameAndPrice(name, price);
	}
	
	@GetMapping("/success")
	public ResponseEntity<String> getSuccessMessage() {
		return ResponseEntity.ok("Congrats! Product is added successfully!");
	}
	
}
