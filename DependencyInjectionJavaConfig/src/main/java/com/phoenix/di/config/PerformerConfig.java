package com.phoenix.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.phoenix.di.instruments.Guitar;
import com.phoenix.di.instruments.Instrument;
import com.phoenix.di.performers.Instrumentalist;
import com.phoenix.di.performers.Performer;

@Configuration
public class PerformerConfig {
	
	@Bean
	public Instrument guitar(){
		return new Guitar();
	}
	
	@Bean
	public Performer instrumentalist() {
		//return new Instrumentalist();
		return new Instrumentalist("Hello");
	}
	
}
