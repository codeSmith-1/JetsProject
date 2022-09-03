package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet{

	public CargoPlane() {
	}
	
	public CargoPlane(String model, long price, double speed, int range) {
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
	}
		
	
}
