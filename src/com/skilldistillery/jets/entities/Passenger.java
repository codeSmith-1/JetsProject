package com.skilldistillery.jets.entities;

public class Passenger extends Jet  {
	
	
	

	public void setModel(String model) {
		this.model = model;
	}

	public Passenger() {
		
	}

	public Passenger(String type, String model, long price, double speed, int range) {
		super(type, model, price, speed, range);
	}
	
	

}
