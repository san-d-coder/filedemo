package com.sandcoder.filedemo;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sandcoder.filedemo.operations.FileOperations;

/**
 * Hello world!
 *
 */
public class App {

	private static FileOperations fileOperations = null;
	private static Scanner scanner = null;
	private static int userInput = 0;
	private static ApplicationContext appContext = null;

	public static void main(String[] args) throws IOException {
		
		 appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		 fileOperations = appContext.getBean(FileOperations.class);
		 
		while (true) {
			showPrompt();

			scanner = new Scanner(System.in);

			userInput = scanner.nextInt();

			switch (userInput) {
			case 1:
				fileOperations.selectFile();
				break;
			case 2:
				fileOperations.writeToFile();
				break;
			case 3:
				fileOperations.readFromFile();
				break;
			case 4:
				fileOperations.deleteFile();
				break;
			case 5:
				System.out.println("Thanks for using FileDemo");
				System.exit(0);
			default:
				System.out.println("Incorrect Input");
			}

		}

	}

	

	public static void showPrompt() {
		System.out.println("Select an option from below:");
		System.out.println("1. Select file");
		System.out.println("2. Write to file");
		System.out.println("3. Read from file");
		System.out.println("4: Delete file");
		System.out.println("5: Exit");
	}
}
