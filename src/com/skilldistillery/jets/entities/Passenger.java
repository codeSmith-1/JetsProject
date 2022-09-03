package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements ChemTrails {

	public Passenger() {
		
	}
	
	public Passenger(String model, long price, double speed, int range) {
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
	}

	@Override
	public void chemTrails() {
		System.out.println("deploying hypnosis gas and changing the weather patterns");
		
	}
	
	

}
