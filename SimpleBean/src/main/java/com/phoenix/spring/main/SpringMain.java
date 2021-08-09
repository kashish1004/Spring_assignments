package com.phoenix.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.phoenix.beans.Greeting;
import com.phoenix.spring.config.SpringConfig;

public class SpringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating spring container object
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Greeting g = context.getBean(Greeting.class);
		System.out.println(g.greet());
		
	}

}
