package com.phoenix.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.phoenix.models.CartItem;
import com.phoenix.proxy.services.ProductServiceProxy;

/* 
* @author kashish.jain@stltech.in
* Creation Date 4-Aug-2021
* Version - 1.0
* Copyright - Sterlite Technologies Ltd.
* @description Shopping cart microService REST API
*/

@RequestMapping("/shop-cart")
@RestController
public class ShoppingCartRestController {
	
	@Autowired
	private ProductServiceProxy proxy;
	
	@GetMapping("/item-id/{id}/quantity/{qty}")
	public CartItem getCartItem(@PathVariable("id") int id,@PathVariable("qty") int quantity){
		
		//calling server microService(product Service) using RestTemplate
		CartItem cartItem =proxy.getCartItemById(id);
		cartItem.setQuantity(quantity);
		
		double itemValue = cartItem.getPrice() * cartItem.getQuantity();
		cartItem.setItemValue(itemValue);
		
		return cartItem;
	}
}
