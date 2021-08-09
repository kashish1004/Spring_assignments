package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.phoenix.di.instruments.Instrument;

/*
 * @author kashish.jain@stltech.in
 * @version 3.0
 * @creation_date 04-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 */

public class Instrumentalist implements Performer {
	
	@Autowired
	private Instrument instrument;
	
	//@Value("Gurenge")
	private String song;
	
	public Instrumentalist() {
		// TODO Auto-generated constructor stub
	}
	
	public Instrumentalist(String song) {
		super();
		this.song = song;
	}



	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing: "+song);
		instrument.play();
	}

}
