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
	private RestTemplate restTemplate;
	
	@GetMapping("/item-id/{id}/quantity/{qty}")
	public CartItem getCartItem(@PathVariable("id") int id,@PathVariable("qty") int quantity){
		
		//server microService URL
		String serverUrl = "http://localhost:8181/products/{id}";
		Map<String, Integer> urlVariables = new HashMap<>();
		urlVariables.put("id", id);
		
		//RestTemplate restTemplate = new RestTemplate();
		
		//calling server microService(product Service) using RestTemplate
		ResponseEntity<CartItem> entity = restTemplate.getForEntity(serverUrl, CartItem.class, urlVariables);
		
		CartItem cartItem = entity.getBody();
		cartItem.setQuantity(quantity);
		
		double itemValue = cartItem.getPrice() * cartItem.getQuantity();
		cartItem.setItemValue(itemValue);
		
		return cartItem;
	}
}
