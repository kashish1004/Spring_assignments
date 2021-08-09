package com.phoenix.data.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.phoenix.data.entities.Products;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 * @description DAO interface or Repository Interface
 */

public interface ProductRepository extends CrudRepository<Products, Integer> {
	List<Products> findByName(String name);
	List<Products> findByBrand(String brand);
	List<Products> findByPrice(float price);
	List<Products> findByPriceBetween(float minPrice,float maxPrice);
	List<Products> findByNameAndBrand(String name,String brand);
	List<Products> findByNameAndPrice(String name,float price);
	List<Products> findByBrandAndPrice(String brand,float price);
	List<Products> findByNameLike(String namePattern);
	List<Products> findByNameOrderByPrice(String name);
	List<Products> findByNameOrderByPriceDesc(String name);
	List<Products> OrderByBrand();
	
	@Query("select * from products order by name")
	List<Products> sortByName();
	
	@Query("select * from products where name =:nm  and price = :pr")
	List<Products> getProductsByNameAndPrice(@Param("nm") String name,@Param("pr") float price);
	
	@Modifying
	@Query("update products set price = price + :pr where brand = :br")
	int updatePriceByBrand(@Param("br") String brand, @Param("pr") float price);
	
	@Modifying
	@Query("delete from products where id = :i")
	boolean deleteProductById(@Param("i") int id);
		
}
