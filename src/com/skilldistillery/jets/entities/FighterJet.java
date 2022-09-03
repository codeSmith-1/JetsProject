package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements DropFlowers{

	public FighterJet() {
		}
	
	public FighterJet(String model, long price, double speed, int range) {
		setModel(model);
		setPrice(price);
		setSpeed(speed);
		setRange(range);
		
	}

	@Override
	public void flowers() {
		System.out.println("making love not war");
		
	}


	
	

}
