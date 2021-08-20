package com.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMe {

	static final String folderPath = "C:\\Users\\DELL\\Documents\\Phase1Project\\LockedMe Files";

	public static void main(String[] args) {

		do {
			// Variable declaration
			Scanner obj = new Scanner(System.in);
			int ch;

			// Menu
			displayMenu();
			System.out.println("Enter your choice:");
			ch = Integer.parseInt(obj.nextLine());

			switch (ch) {

			case 1:
				displayListOfFiles();
				break;

			case 2:
				createFiles();
				break;

			case 3:
				deleteFile();
				break;

			case 4:
				searchFile();
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}

		} while (true);
	}

	/**
	 * This method will display the menu of the Application.
	 */
	public static void displayMenu() {

		System.out.println("***********************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("***********************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
	}

	/**
	 * This method is called when user choose Option-1:Display all files.
	 */
	public static void displayListOfFiles() {

		// Getting all the file names into the List of String
		List<String> fileNames = FileManager.getAllFiles(folderPath);

		// Check if the directory is empty
		if (fileNames.isEmpty())
			System.out.println("No files in the directory");
		// Otherwise, display the list of files
		else {
			System.out.println("The list of files is below:");

			// Sorting in ascending order
			Collections.sort(fileNames);

			// Displaying the list
			for (String f : fileNames)
				System.out.println(f);
		}
	}

	/**
	 * This method is called when user choose Option-2:Add new file.
	 */
	public static void createFiles() {

		// Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();

		// Read the file name from user
		System.out.println("Enter the file name");
		fileName = obj.nextLine();

		// Read number of lines from user
		System.out.println("Enter how many lines in the file:");
		linesCount = Integer.parseInt(obj.nextLine());

		// Read lines from user
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			content.add(obj.nextLine());
		}

		// Save the content into the file
		boolean isSaved = FileManager.createFiles(folderPath, fileName, content);

		if (isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Some error occured. Please contact admin@ss.com");
	}

	/**
	 * This method is called when user choose Option-3:Delete a file.
	 */
	public static void deleteFile() {

		// Variable declaration
		String fileName;
		Scanner obj = new Scanner(System.in);

		// Read the file name from user
		System.out.println("Enter file name to be deleted:");
		fileName = obj.nextLine();

		// Delete the file
		boolean isDeleted = FileManager.deleteFile(folderPath, fileName);

		if (isDeleted)
			System.out.println("File Deleted successfully");
		else
			System.out.println("Either file not there or some access issue");

	}

	/**
	 * This method is called when user choose Option-4:Search a file.
	 */
	public static void searchFile() {

		// Variable declaration
		String fileName;
		Scanner obj = new Scanner(System.in);

		// Read the file name from user
		System.out.println("Enter file name to be searched:");
		fileName = obj.nextLine();

		// Find the file
		boolean isFound = FileManager.searchFile(folderPath, fileName);

		if (isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("File is not present in the folder");
	}
}