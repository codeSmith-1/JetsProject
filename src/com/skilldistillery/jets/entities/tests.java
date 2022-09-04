package com.skilldistillery.jets.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class tests {
private static final DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		double speed = 700;
		int range = 3000;
		double value = range/speed;
		int newVal = (int) (value);
		
		BigDecimal bd = BigDecimal.valueOf(value);
		
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		double minutes = value - newVal;
		
		System.out.println(value);
		
		System.out.println(newVal);
		
		System.out.println(minutes);
		
		System.out.println("minutes: "+ df.format(minutes));
		
	}

}
