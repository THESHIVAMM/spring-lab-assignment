package com.demo;

import org.springframework.stereotype.Component;

//<bean id="v2" class="com.demo.Car"/>
@Component(value = "v2")
public class Car  implements Vehical{
	public void move() {
		System.out.println("moving in a car");
	}
}
