package com.phoenix.proxy.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phoenix.models.CartItem;

/* 
* @author kashish.jain@stltech.in
* Creation Date 4-Aug-2021
* Version - 1.0
* Copyright - Sterlite Technologies Ltd.
* @description Feign Proxy Interface to look for server microservice
*/

@FeignClient(name = "product-service",url = "localhost:8181")
public interface ProductServiceProxy {
	
	@GetMapping("/products/{id}")
	CartItem getCartItemById(@PathVariable("id") int id);
}
