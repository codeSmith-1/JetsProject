package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

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
	}

	private void menu() {
		JetsApplication jetApp = new JetsApplication();

		boolean loopMenu = true;

		while (loopMenu) {
			printMenu();

			System.out.println("Select an option from the menu");

			int input = kb.nextInt();

			switch (input) {
			case 1:
				for (Jet jet : fleet) {
					System.out.println(jet);
				}
				break;
			case 2:
				for (Jet jet : fleet) {
					jet.fly();
				}

				break;
			case 3: {
				Jet fastJet = null;
				double max = Integer.MIN_VALUE;
				for (Jet jet : fleet) {
					if (jet.getSpeed() > max) {
						max = jet.getSpeed();
						fastJet = jet;
					}
				}
				System.out.println(fastJet);
			}
				break;
			case 4:
				Jet longRange = null;
				int maxRange = Integer.MIN_VALUE;
				for (Jet jet : fleet) {
					if (jet.getRange() > maxRange) {
						maxRange = jet.getRange();
						longRange = jet;
					}
				}
				System.out.println(longRange);

				break;
			case 5:
				for (Jet jet : fleet) {
					if (jet instanceof FighterJet) {
						((FighterJet) jet).flowers();
					}
				}

				break;
			case 6:
				for (Jet jet : fleet) {
					if (jet instanceof CargoPlane) {
						((CargoPlane) jet).chemTrails();
					}
				}

				break;
			case 7:
				Jet userJet = null;
				String jetTypeString = jetApp.typeOfJet();
				System.out.println("What model is the jet?");
				String jetModel = kb.next();
				System.out.println("How much is th jet $ ?");
				long jetCost = kb.nextLong();
				System.out.println("How fast is the jet?");
				double jetSpeed = kb.nextDouble();
				System.out.println("What is the jet's range");
				int jetRange = kb.nextInt();
				if (jetTypeString.equalsIgnoreCase("passenger")) {
					userJet = new Passenger(jetTypeString, jetModel, jetCost, jetSpeed, jetRange);
				}
				if (jetTypeString.equalsIgnoreCase("Fighter")) {
					userJet = new FighterJet(jetTypeString, jetModel, jetCost, jetSpeed, jetRange);
				}
				if (jetTypeString.equalsIgnoreCase("cargo")) {
					userJet = new CargoPlane(jetTypeString, jetModel, jetCost, jetSpeed, jetRange);
				}
				fleet.add(userJet);
				System.out.println("You added: " + userJet);

				break;

			case 8:

				int count = 1;
				for (Jet jet : fleet) {
					System.out.println(count + " " + jet);
					count++;
				}
				System.out.println();
//				jetApp.removeByNumber();
				boolean done = false;
				while (!done) {
					System.out.println("Enter a number to delete the corresponding plane");
					int userInput = kb.nextInt();
					if (userInput <= fleet.size() && userInput > 0) {
						userInput -= 1;
						fleet.remove(userInput);
						System.out.println("you removed " + fleet.get(userInput));
						done = true;
					} else {
						System.err.println("Please choose a number that corresponds with a plane.");
					}
				}

				break;
			case 9:
				System.out.println("Goodbye");
				loopMenu = false;

				break;
			default:
				System.err.println("Command not recognized.");
			}
		}
	}

	public void printMenu() {
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
	}
	
	public String typeOfJet() {
		System.out.println("What type of jet do you want to create?");
		System.out.println("Cargo");
		System.out.println("Passenger");
		System.out.println("Fighter");
		String userJet = kb.next().toUpperCase();
		return userJet;
	}

}
