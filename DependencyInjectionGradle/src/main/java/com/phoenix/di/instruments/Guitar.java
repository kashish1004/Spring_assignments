package com.phoenix.di.instruments;

import org.springframework.stereotype.Component;

/*
 * @author kashish.jain@stltech.in
 * @version 2.0
 * @creation_date 29-jul-2021
 * @copyright Sterlite Technologies Ltd.
 * @description Spring bean class
 */
@Component
public class Guitar implements Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Ting ting ting..");
	}

}
