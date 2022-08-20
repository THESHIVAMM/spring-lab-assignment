package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.demo.Bike;
import com.demo.Car;
import com.demo.Passanger;
import com.demo.Vehical;

@Configuration
@ComponentScan(basePackages = { "com.demo" })
public class AppConfig {
	
	@Autowired
	@Bean(name = "p")
	public Passanger getPassanger(Vehical vehical) {
		Passanger passanger = new Passanger();
		passanger.setName("raj");
		passanger.setVehical(vehical);
		return passanger;
	}

	@Primary
	@Profile("pre-prod")
	@Bean
	public Vehical getCar() {
		Vehical vehical = new Car();
		return vehical;
	}

	@Profile("dev")
	@Bean
	public Vehical getBike() {
		Vehical vehical = new Bike();
		return vehical;
	}
}
