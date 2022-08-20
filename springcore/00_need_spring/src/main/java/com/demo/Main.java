package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
//		Vehical vehical=new Bike();
//		
//		Passanger passanger=new Passanger();
//		
//		passanger.setName("raj");
//		passanger.setVehical(vehical);
//		
//		passanger.travel();
		
		//now i want to use spring framework
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		
		Passanger passanger=(Passanger) ctx.getBean("p");
		Passanger passangerb=(Passanger) ctx.getBean("pb");
//		System.out.println(passanger.hashCode());
	
		System.out.println("---------------");
		passanger.travel();
		passangerb.travel();
	}

}





