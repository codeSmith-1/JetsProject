package com.skilldistillery.jets.entities;

public class Jet {
	

	protected String model;
	protected long price;
	protected double speed;
	protected int range;
	protected String type;

	public Jet(){}
	
	public Jet(String type, String model, long price, double speed, int range) {
		this.model = model;
		this.price = price;
		this.speed = speed;
		this.range = range;
		this.type = type;
	}

	@Override
	public String toString() {
		return model + ", price= " + price + ", speed= " + speed + ", range= " + range;
	}


	public void fly() {
		System.out.println(type +", "+ model + ", price: "+ price + " speed: " + speed + ", range: " + range + "flight time: "+flyTime() + "hours");
		
	}

	protected double mach() {
		return speed * 0.001303;
	}

	protected String getType() {
		return type;
	}
	
	protected void setType(String type) {
		this.type = type;
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

	public double getSpeed() {
		return speed;
	}

	protected void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	protected void setRange(int range) {
		this.range = range;
	}
	
	protected double flyTime() {
		return range / speed;
	}



}
