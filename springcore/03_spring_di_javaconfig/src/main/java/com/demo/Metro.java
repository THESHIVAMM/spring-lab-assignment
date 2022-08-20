package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//<bean id="v1" class="com.demo.Bike" primary="true"/>
@Component(value = "v3")
@Primary
public class Metro implements Vehical{
	public void move() {
		System.out.println("moving in a metro");
	}
}
