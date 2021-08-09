package com.phoenix.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 28-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */

//Bean class of Spring
@Component
public class Greeting {
	@Value("Happy Birthday!")
	private String message;
	
	public Greeting() {
		// TODO Auto-generated constructor stub
		System.out.println("Greeting obj is created");
	}
	
	//Business logic method
	public String greet() {
		return message;
	}
}
