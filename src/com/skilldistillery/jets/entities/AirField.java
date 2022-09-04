package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	public List<Jet> getHanger() {
		return hanger;
	}

	List<Jet> hanger = new ArrayList<>();

	public void readFromFile() {
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String jets;

			while ((jets = br.readLine()) != null) {
				String[] jetInfo = jets.split(", ");
				Jet j = null;

				String type = jetInfo[0];
				String model = jetInfo[1];
				long price = Long.parseLong(jetInfo[2]);
				double speed = Double.parseDouble(jetInfo[3]);
				int range = Integer.parseInt(jetInfo[4]);
				if (type.equalsIgnoreCase("passenger")) {
					j = new Passenger(type, model, price, speed, range);
				} else if (type.equalsIgnoreCase("fighter")) {
					j = new FighterJet(type, model, price, speed, range);
				} else if (type.equalsIgnoreCase("cargo")) {
					j = new CargoPlane(type, model, price, speed, range);
				}
				hanger.add(j);
			}

			br.close();
		} catch (IOException e) {
			System.err.println("Problem while reading names.txt" + ": " + e.getMessage());
		}
	}
}
