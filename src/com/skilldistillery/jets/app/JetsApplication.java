package com.skilldistillery.jets.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	Scanner kb = new Scanner(System.in);

	AirField af = new AirField();
	List<Jet> fleet = af.getHanger();

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	public void launch() {
		af.readFromFile();
		menu();
		String input = kb.next();
	}

	private void menu() {
		boolean loopMenu = true;

		while (loopMenu) {
			System.out.println("_________Menu__________");
			System.out.println("1- List Fleet");
			System.out.println("2- Fly all jets");
			System.out.println("3- View fastest jet");
			System.out.println("4- View jet with longest range");
			System.out.println("5- Make love not war");
			System.out.println("6- Change the weather");
			System.out.println("7- Add a jet to Fleet");
			System.out.println("8- Remove a jet from Fleet");
			System.out.println("9- Quit");
			
			System.out.println("Select an option from the menu");
			String input = kb.nextLine();
			switch (input) {
				case "1" : {
					for (Jet jet : fleet) {
						System.out.println(jet);
					}
				}
				case "2" : {
					for (Jet jet : fleet) {
						jet.fly();
					}
				}
				case "3" : {
					Jet fastJet = null;
					double max = Integer.MIN_VALUE;		
					for (Jet jet : fleet) {
						if(jet.getSpeed() > max) {
							max = jet.getSpeed();
							fastJet = jet;
						}
					}
					System.out.println(fastJet);
				}
				case "4" : {
					Jet longRange = null;
					int maxRange = Integer.MIN_VALUE;		
					for (Jet jet : fleet) {
						if(jet.getRange() > maxRange) {
							maxRange = jet.getRange();
							longRange = jet;
						}
					}
					System.out.println(longRange);
					
				}
				case "5" : {
					System.out.println(FighterJet.flowers());
					
				}
				case "6" : {
					
				}
				case "7" : {
					
				}
				case "8" : {
					
				}
				case "9" : {
					
				}
			default:
				throw new IllegalArgumentException("Select a valid option");
			}
		}
		
	}

}