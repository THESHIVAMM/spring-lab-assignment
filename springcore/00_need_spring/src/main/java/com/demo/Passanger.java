package com.demo;

public class Passanger {
	private String name;
	private Vehical vehical;

	public Passanger() {
		System.out.println("ctr of passanger is called");
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	public void travel() {
		System.out.println("name: " + name);
		vehical.move();
	}
}
