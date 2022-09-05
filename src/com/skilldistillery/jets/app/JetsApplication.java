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
			case 3:
				Jet fastJet = null;
				double max = Integer.MIN_VALUE;
				for (Jet jet : fleet) {
					if (jet.getSpeed() > max) {
						max = jet.getSpeed();
						fastJet = jet;
					}
				}
				System.out.println(fastJet);

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
				fleet.add(jetApp.typeOfJet());
				break;

			case 8:
				int count = 1;
				for (Jet jet : fleet) {
					System.out.println(count + " " + jet);
					count++;
				}
				System.out.println();
				boolean done = false;
				while (!done) {
					System.out.println("Enter a number to delete the corresponding plane");
					int userInput = kb.nextInt();
					if (userInput > 0 && userInput <= fleet.size()) {
						userInput--;
						System.out.println("you removed " + fleet.get(userInput));
						fleet.remove(userInput);

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
		System.out.println("7- Add a jet to fleet");
		System.out.println("8- Remove a jet from the fleet");
		System.out.println("9- Quit");
	}

	public Jet typeOfJet() {
		Jet userJet = null;

// Let user choose which jet type to create
		String jetTypeInput = "";
		boolean typeInput = true;
		do {
			// Get input
			System.out.println("What type of jet do you want to create?");
			System.out.println("Cargo");
			System.out.println("Passenger");
			System.out.println("Fighter");

			jetTypeInput = kb.next().toUpperCase();
			if (jetTypeInput.equals("PASSENGER") || jetTypeInput.equals("CARGO") || jetTypeInput.equals("FIGHTER")) {
				typeInput = false;
			} else {
				typeInput = true;
				System.err.println("Enter a valid jet type.");
			}

		} while (typeInput);
// capture model
		System.out.println("Enter the model: ");
		String jetModel = kb.next();

// capture price and throw exception for invalid data type
		boolean running = true;
		long jetCost = 0;
		do {
			try {
				// Get input
				System.out.println("Enter the price: ");
				jetCost = kb.nextLong();
				running = false;
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number.");
				running = true;
			}
			kb.nextLine();
		} while (running);

// capture speed and throw exception for invalid data type
		boolean nextInput = true;
		double jetSpeed = 0;
		do {
			try {
				// Get input
				System.out.println("Enter the speed: ");
				jetSpeed = kb.nextDouble();
				nextInput = false;
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number.");
				running = true;
			}
			kb.nextLine();
		} while (nextInput);

// capture range and throw exception for invalid data type

		boolean getJetRange = true;
		int jetRange = 0;
		do {
			try {
				// Get input
				System.out.println("Enter the range: ");
				jetRange = kb.nextInt();
				getJetRange = false;
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number.");
				running = true;
			}
			kb.nextLine();
		} while (getJetRange);

// create appropriate jet type with user input
		if (jetTypeInput.equalsIgnoreCase("passenger")) {
			userJet = new Passenger(jetTypeInput, jetModel, jetCost, jetSpeed, jetRange);
		}
		if (jetTypeInput.equalsIgnoreCase("Fighter")) {
			userJet = new FighterJet(jetTypeInput, jetModel, jetCost, jetSpeed, jetRange);
		}
		if (jetTypeInput.equalsIgnoreCase("cargo")) {
			userJet = new CargoPlane(jetTypeInput, jetModel, jetCost, jetSpeed, jetRange);
		}

		System.out.println("You added: " + userJet);
		return userJet;
	}

}
