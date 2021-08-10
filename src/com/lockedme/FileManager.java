package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderPath) {
		
		//Creating File object
		File f1 = new File(folderPath);
		
		//Getting all the files into Array of File
		File[] listOfFiles = f1.listFiles();
		
		//Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
		
		//return the List
		return fileNames;		
	}
}
