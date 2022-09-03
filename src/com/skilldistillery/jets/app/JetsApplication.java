package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	Scanner kb = new Scanner(System.in);
			
	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	public void launch() {
		JetsApplication app = new JetsApplication();
		AirField af = new AirField();
		
		app.menu();
		String input = kb.next();
			
		
	}
	
	private void menu() {
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

}