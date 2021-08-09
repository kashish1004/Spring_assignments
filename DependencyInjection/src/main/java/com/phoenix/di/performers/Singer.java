package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */

@Component
public class Singer implements Performer {
	
	@Value("Faded")
	private String song;
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Singer is singing: "+song);
	}

}
