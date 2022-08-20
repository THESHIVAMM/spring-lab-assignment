package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {
	private String foo;

	public Foo() {
		System.out.println("foo ctr");
	}
	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		System.out.println("setFoo is called");
		this.foo = foo;
	}
	
	@PostConstruct
	public void afterCreation() {
		System.out.println("it is called after bean is created...");
	}
	public void print() {
		System.out.println(" value is " + foo);
	}
	
	@PreDestroy
	public void beforeBeanDestroyed() {
		System.out.println("it is called before bean is destroyed...");
	}
}
