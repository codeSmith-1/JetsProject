package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet{

	public CargoPlane() {
	}
	
	public CargoPlane(String type, String model, long price, double speed, int range) {
		setType(type);
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
	}
		
	@Override
	public String toString() {
		return type +" model= " + model + ", price= " + price + ", speed= " + speed + ", range= " + range;
	
	}
}
