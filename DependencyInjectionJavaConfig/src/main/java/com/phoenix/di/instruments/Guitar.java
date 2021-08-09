package com.phoenix.di.instruments;

/*
 * @author kashish.jain@stltech.in
 * @version 3.0
 * @creation_date 04-Aug-2021
 * @copyright Sterlite Technologies Ltd.
 * @description Spring bean class
 */

public class Guitar implements Instrument {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Ting ting ting..");
	}

}
