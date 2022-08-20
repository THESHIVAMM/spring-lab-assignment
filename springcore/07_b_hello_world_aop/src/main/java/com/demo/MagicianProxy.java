package com.demo;

public class MagicianProxy extends Magician {
	
	private Audience audience=new Audience();
	
	public void doMagic() {
		System.out.println("abra ka dabra...");
		audience.clapping();
	}
}
