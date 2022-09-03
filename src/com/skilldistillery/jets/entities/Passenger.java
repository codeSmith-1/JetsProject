package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements ChemTrails {

	public Passenger() {
		
	}
	
	public Passenger(String type, String model, long price, double speed, int range) {
		setType(type);
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
	}

	@Override
	public void chemTrails() {
		System.out.println("deploying chem trails to change the weather");
		
	}
	
	@Override
	public String toString() {
		return type +" model= " + model + ", price= " + price + ", speed= " + speed + ", range= " + range;
	
	}

}
