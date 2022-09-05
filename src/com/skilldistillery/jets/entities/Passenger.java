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
	
//	public Passenger(String type, String model, long price, double speed, int range) {
//		setType(type.toUpperCase());
//		setModel(model);
//		setPrice(price);
//		setSpeed(speed);
//		setRange(range);
//	}

		
//	@Override
//	public String toString() {
//		return type + " model: " + model + ", price: " + price + ", speed: " + speed + ", range: " + range;
//	
//	}
	
	
	

}
