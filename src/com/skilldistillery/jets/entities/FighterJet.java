package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements DropFlowers{


	public FighterJet() {
		}
	
	@Override
	public void flowers() {
		System.out.println(this.model + " flowers away!");
	}

	public FighterJet(String type, String model, long price, double speed, int range) {
		super(type, model, price, speed, range);
	}

}
