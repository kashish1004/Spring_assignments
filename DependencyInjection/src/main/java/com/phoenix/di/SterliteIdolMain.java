package com.phoenix.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.phoenix.di.config.PerformerConfig;
import com.phoenix.di.performers.Performer;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */
public class SterliteIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating spring IoC container object
		ApplicationContext context = new AnnotationConfigApplicationContext(PerformerConfig.class);
		Performer p = context.getBean("pyaree_mohan", Performer.class);
		p.perform();
		
		Performer s = context.getBean("singer", Performer.class);
		s.perform();
		
	}

}
