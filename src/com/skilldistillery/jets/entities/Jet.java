package com.skilldistillery.jets.entities;

public class Jet {
	
	protected String model;
	protected long price;
	protected double speed;
	protected int range;

	public Jet(){}
	
	public Jet(String model, long price, double speed, int range) {
		this.model = model;
		this.price = price;
		this.speed = speed;
		this.range = range;
	}

	@Override
	public String toString() {
		return model + ", price= " + price + ", speed= " + speed + ", range= " + range;
	}


	protected void fly() {
		System.out.println(model + ", price: "+ price + " speed: " + speed + ", range: " + range + "flight time: "+flyTime());
		
	}

	protected double mach() {
		return speed * 0.001303;
	}

	protected String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	protected long getPrice() {
		return price;
	}

	protected void setPrice(long price) {
		this.price = price;
	}

	protected double getSpeed() {
		return speed;
	}

	protected void setSpeed(double speed) {
		this.speed = speed;
	}

	protected int getRange() {
		return range;
	}

	protected void setRange(int range) {
		this.range = range;
	}
	
	protected double flyTime() {
		return range / speed;
	}



}
