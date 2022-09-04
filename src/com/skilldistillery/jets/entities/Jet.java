package com.skilldistillery.jets.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Jet {
	

	protected String type;
	protected String model;
	protected long price;
	protected double speed;
	protected int range;
	

	
	public Jet(){
		
	}
	
	public Jet(String type, String model, long price, double speed, int range) {
		this.model = model;
		this.price = price;
		this.speed = speed;
		this.range = range;
		this.type = type;
	}

	
	
	
	@Override
	public String toString() {
		return type +", "+ "model: " + model + ", price: "+ price + ", speed (MPH/Mach): " + speed +"/"+mach()+ ", range: " + range + " miles";
	}

	public double flyTime() {
		double value = range / speed;
		
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}

	public void fly() {
		System.out.println(type +", "+ "model: " + model + ", price: "+ price + "  speed (MPH/Mach): " + speed +"/"+mach()+ " range: " + range + " flight time: "+flyTime() + " hours");
		
	}

	public double mach() {
		double value = speed * 0.00130332;
		
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
		
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	



}
