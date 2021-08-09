package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.phoenix.di.instruments.Instrument;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 * @description Instrumentalist is a dependent object which 
 *              depends on Dependency object instrument
 */
@Component("pyaree_mohan")
public class Instrumentalist implements Performer {
	
	//dependency
	@Autowired	//used to achieve dependency injection for complex objects
	private Instrument instrument;
	
	@Value("Gurenge") //used to inject value in simple property
	private String song;
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing: "+song);
		instrument.play();
	}

}
