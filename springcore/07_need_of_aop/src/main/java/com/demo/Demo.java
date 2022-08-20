package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Magician magician=(Magician) ctx.getBean("magician");
		
		String val=magician.doMagic();
		System.out.println(val);
		
	}
}
