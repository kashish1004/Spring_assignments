package com.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ShoppingCartServiceFeignRibbonLbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServiceFeignRibbonLbApplication.class, args);
	}

}
