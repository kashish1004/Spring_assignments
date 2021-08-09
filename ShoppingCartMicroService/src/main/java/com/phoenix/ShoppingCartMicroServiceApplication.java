package com.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShoppingCartMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartMicroServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate get() {
		return new RestTemplate();
	}

}
