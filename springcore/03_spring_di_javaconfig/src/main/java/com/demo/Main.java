package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;

public class Main {
	
	public static void main(String[] args) {
	
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		Passanger passanger=(Passanger) ctx.getBean("p");

		passanger.travel();
	}

}





