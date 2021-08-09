package com.phoenix.utilities;

import com.phoenix.models.CartItem;

public class CartServiceInfo {
	
	private CartItem product;
	private int serverPort;
	
	public CartServiceInfo() {
		// TODO Auto-generated constructor stub
	}

	public CartServiceInfo(CartItem product, int serverPort) {
		super();
		this.product = product;
		this.serverPort = serverPort;
	}

	public CartItem getProduct() {
		return product;
	}

	public void setProduct(CartItem product) {
		this.product = product;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	public String toString() {
		return "CartServiceInfo [product=" + product + ", serverPort=" + serverPort + "]";
	}
	
	
}
