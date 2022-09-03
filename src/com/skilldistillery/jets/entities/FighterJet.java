package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements DropFlowers{


	public FighterJet() {
		}
	
	public FighterJet(String type, String model, long price, double speed, int range) {
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

	@Override
	public void flowers() {
		System.out.println("making love not war");
		
	}

}
