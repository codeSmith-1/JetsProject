package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AirField {
	
	public static void main(String[] args) {
		AirField af = new AirField();
		String file = "jets.txt";
		List<Jet> hanger = af.readFromFile(file);
		
		System.out.println(hanger);
		System.out.println(hanger.get(0));
		System.out.println(hanger.get(1));
		System.out.println(hanger.get(2));
		System.out.println(hanger.get(3));
		System.out.println(hanger.get(0).getSpeed());
	}


	
	private List<Jet> readFromFile(String jetFile) {
		
		List<Jet> hanger = new ArrayList<>();
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String jets;

			while ((jets = br.readLine()) != null) {
				 String[] jetInfo = jets.split(", ");
				 String model = jetInfo[0];
				 System.out.println(model);
				 long price = Long.parseLong(jetInfo[1]);
			     double speed = Double.parseDouble(jetInfo[2]);
			     int range = Integer.parseInt(jetInfo[3]);
			     Jet j = new Jet(model, price, speed, range);
				hanger.add(j);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return hanger;
		} catch (IOException e) {
			System.err.println("Problem while reading names.txt" + ": " + e.getMessage());
			return hanger;
		}
		return hanger;
	}
}
