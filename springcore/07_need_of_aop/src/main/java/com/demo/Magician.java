package com.demo;

import org.springframework.stereotype.Component;

@Component(value = "magician")
 public class Magician {
	
	public String doMagic() {
		System.out.println("abra ka dabra...");
		return "get rabbit out of hat";
	}
	
	public void doEat() {
		System.out.println("doing lunch...");
	}
	
	public void doCalling() {
		System.out.println("calling family..");
	}
	
}
