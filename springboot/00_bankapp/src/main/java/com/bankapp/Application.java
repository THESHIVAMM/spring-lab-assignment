package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
 * @SpringBootApplication= @SpringBootConfiguration+ @EnableAutoConfiguration+ @ComponentScan
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(Application.class, args);
		//Spring boot use auto config of the beans ? how it does...
//		String []beanNames=ctx.getBeanDefinitionNames();
//		for(String name:beanNames) {
//			System.out.println(name);
//		}
	}

}
