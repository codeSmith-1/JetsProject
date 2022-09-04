package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements DropFlowers{


	public FighterJet() {
		}
	
	public FighterJet(String type, String model, long price, double speed, int range) {
		setType(type.toUpperCase());
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
		
	}
	
	

	@Override
	public void flowers() {
		System.out.println(this.model + " flowers away!");
		
	}

}
