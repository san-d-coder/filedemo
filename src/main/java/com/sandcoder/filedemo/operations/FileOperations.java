package com.sandcoder.filedemo.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileOperations {
	
	private static Scanner scanner = null;
	private static String fileName = null;
	private static String message = null;
	private static File file = null;
	private static FileWriter fileWriter = null;
	
	public FileOperations() {
		scanner = new Scanner(System.in);
	}
	
	public void selectFile() {
		
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

	public void writeToFile() {
		
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

	public void readFromFile() {
		Scanner scanner2 = null;
		if(fileName == null)
			System.out.println("No files selected.");
		else {
			try {
				scanner2 = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if(!scanner2.hasNext())
				System.out.println("File empty, add a message first!");
			while(scanner2.hasNext())
				System.out.println(scanner2.next());
			scanner2.close();
		}

	}
	
	public void deleteFile() {
		if(fileName == null) 
			System.out.println("No files selected");
		else {
			if(file.delete()) {
				System.out.println("File "+fileName+".txt deleted successfully");
				file = null;
				fileName = null;
				fileWriter = null;
				message = null; 
			}
			else
				System.out.println("Cannot delete this file: "+fileName+".txt");
		}
	}
}
