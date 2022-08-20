package com.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//<bean id="v1" class="com.demo.Bike" primary="true"/>
//@Lazy
@Component(value = "v1")
//@Primary
public class Bike implements Vehical{
	public void move() {
		System.out.println("moving on a bike");
	}
}
