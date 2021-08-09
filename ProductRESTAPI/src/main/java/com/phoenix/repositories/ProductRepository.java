package com.phoenix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.phoenix.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(float price);
	List<Product> findByPriceBetween(float minPrice,float maxPrice);
	List<Product> findByNameAndBrand(String name,String brand);
	List<Product> findByNameAndPrice(String name,float price);
	List<Product> findByBrandAndPrice(String brand,float price);
	List<Product> findByNameLike(String namePattern);
	List<Product> findByNameOrderByPrice(String name);
	List<Product> findByNameOrderByPriceDesc(String name);
	List<Product> OrderByBrand();
	
	@Query("select p from Product p where p.name = ?1 and p.price = ?2")
	List<Product> getProductsByNameAndPrice(String name,float Price);
	
	@Transactional
	@Modifying
	@Query("Update Product p set p.price = p.price + ?2 where p.brand = ?1")
	int updatePriceByBrand(String brand, float price);
	
	@Transactional
	@Modifying
	@Query("delete from Product p where p.id = ?1")
	int deleteProductById(int id);
}
