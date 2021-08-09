package com.phoenix.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.models.CartItem;
import com.phoenix.proxy.services.ProductServiceProxy;
import com.phoenix.utilities.CartServiceInfo;

@RequestMapping("/cart-info")
@RestController
public class CartServiceInfoRestController {
	
	@Autowired
	private ProductServiceProxy proxy;
	
	@GetMapping("/item-id/{id}/quantity/{qty}")
	public CartServiceInfo getCartInfo(@PathVariable("id") int id, @PathVariable("qty") int quantity) {
		CartServiceInfo serviceInfo = proxy.getCartServiceInfo(id);
		CartItem item = serviceInfo.getProduct();
		item.setQuantity(quantity);
		item.setItemValue(item.getPrice() * item.getQuantity());
		serviceInfo.setProduct(item);
		return serviceInfo;
	}
}
