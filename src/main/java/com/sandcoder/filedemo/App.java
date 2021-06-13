package com.sandcoder.filedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	private static Scanner scanner = null;
	private static String fileName = null;
	private static String message = null;
	private static File file = null;
	private static FileWriter fileWriter = null;
	private static int userInput = 0;

	public static void main(String[] args) throws IOException {

		while (true) {
			showPrompt();

			scanner = new Scanner(System.in);

			userInput = scanner.nextInt();

			switch (userInput) {
			case 1:
				createFile();
				break;
			case 2:
				writeToFile();
				break;
			case 3:
				readFromFile();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Incorrect Input");
			}

		}

	}

	public static void createFile() {

		System.out.println("Enter the file name: ");
		fileName = scanner.next();

		file = new File(fileName + ".txt");

		try {
			if (file.createNewFile())
				System.out.println("File " + fileName + ".txt created and selected successfully");
			else
				System.out.println("File " + fileName + ".txt already exists and selected.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeToFile() {
		
		if(fileName==null)
			System.out.println("No files selected.");
		else {
			System.out.println("Enter the message: ");
			message = scanner.next();
			
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(message);
				fileWriter.close();
				System.out.println("Message added: "+ message);
			} catch (IOException e) {
				System.out.println("An error occurred!");
				e.printStackTrace();
			}
		}

	}

	public static void readFromFile() {
		if(fileName == null)
			System.out.println("No files selected.");
		else {
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if(!scanner.hasNext())
				System.out.println("File empty, add a message first!");
			while(scanner.hasNext())
				System.out.println(scanner.next());
		}

	}

	public static void showPrompt() {
		System.out.println("Select an option from below:");
		System.out.println("1. Create new file");
		System.out.println("2. Write to file");
		System.out.println("3. Read from file");
	}
}
