package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements ChemTrails{

	public CargoPlane() {
	}
	
	public CargoPlane(String type, String model, long price, double speed, int range) {
		setType(type.toUpperCase());
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
	}
		
	

	@Override
	public void chemTrails() {
		System.out.println(this.model + " releasing chemtrails to change the weather!");
		
	}
}
