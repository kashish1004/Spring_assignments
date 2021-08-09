package com.phoenix.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * @author kashish.jain@stltech.in
 * @version 1.0
 * @creation_date 28-jul-2021
 * @copyright Sterlite Technologies Ltd.
 */

//Spring Configuration class
@Configuration
@ComponentScan(basePackages = "com.phoenix.beans")
public class SpringConfig {
	
}
