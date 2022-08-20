package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "p") //<bean id="p" class="com.demo.Passanger"
public class Passanger {
	
	@Value("raj") //<property name="name" value="raj"/>
	private String name;
	
	@Autowired	// autowire="byType"
	private Vehical vehical;

	public Passanger() {
		System.out.println("ctr of passanger is called");
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	public void travel() {
		System.out.println("name: " + name);
		vehical.move();
	}
}
