package com.phoenix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.phoenix.di.performers.Performer;

@SpringBootApplication
public class DependencyInjectionJavaConfigApplication implements CommandLineRunner{
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionJavaConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Performer p = context.getBean("instrumentalist", Performer.class);
		p.perform();	
	}

}
