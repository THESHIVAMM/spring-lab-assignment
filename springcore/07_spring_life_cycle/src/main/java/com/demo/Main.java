package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		ctx.registerShutdownHook();//hey spring to respect @PreDestroy annotation
		Foo foo=(Foo) ctx.getBean("foo");
		foo.print();
	}

}





