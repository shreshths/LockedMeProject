package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	/**
	 * This method will return the file names from the folder.
	 * 
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderPath) {

		// Creating File object
		File f1 = new File(folderPath);

		// Getting all the files into Array of Files
		File[] listOfFiles = f1.listFiles();

		// Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();

		for (File f : listOfFiles)
			fileNames.add(f.getName());

		// return the List
		return fileNames;
	}

	/**
	 * This method will create or append content into the file specified.
	 * 
	 * @param folderPath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createFiles(String folderPath, String fileName, List<String> content) {

		try {

			// Creating File object
			File f1 = new File(folderPath, fileName);

			// Creating FileWriter object
			FileWriter fw = new FileWriter(f1);

			for (String s : content) {
				fw.write(s + "\n");
			}

			// Closing FileWriter object
			fw.close();
			return true;
		}

		catch (Exception ex) {

			return false;
		}
	}

	/**
	 * This method will delete the file specified if it exists.
	 * 
	 * @param folderPath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderPath, String fileName) {

		// Creating File object
		File file = new File(folderPath + "\\" + fileName);

		try {

			// Deleting a file
			if (file.delete())
				return true;
			else
				return false;
		}

		catch (Exception ex) {
			return false;
		}
	}

	/**
	 * This method will search the file from the folder.
	 * 
	 * @param folderPath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderPath, String fileName) {

		// Creating File object
		File file = new File(folderPath + "\\" + fileName);

		if (file.exists())
			return true;
		else
			return false;
	}
}