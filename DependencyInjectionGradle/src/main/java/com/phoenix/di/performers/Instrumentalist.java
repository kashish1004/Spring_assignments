package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.phoenix.di.instruments.Instrument;

/*
 * @author kashish.jain@stltech.in
 * @version 2.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */
@Component
public class Instrumentalist implements Performer {
	
	@Autowired
	private Instrument instrument;
	
	@Value("Gurenge")
	private String song;
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing: "+song);
		instrument.play();
	}

}
