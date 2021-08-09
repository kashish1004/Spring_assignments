package com.phoenix.proxy.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phoenix.models.CartItem;
import com.phoenix.utilities.CartServiceInfo;

/* 
* @author kashish.jain@stltech.in
* Creation Date 4-Aug-2021
* Version - 1.0
* Copyright - Sterlite Technologies Ltd.
* @description Feign Proxy Interface to look for server microservice
*/

@FeignClient(name = "product-service")
@RibbonClient(name = "product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/products/{id}")
	CartItem getCartItemById(@PathVariable("id") int id);
	
	@GetMapping("/product-info/product/{myid}")
	CartServiceInfo getCartServiceInfo(@PathVariable("myid") int id);
}
