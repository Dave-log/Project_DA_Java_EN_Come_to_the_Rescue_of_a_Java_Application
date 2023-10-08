package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the ISymptomReader interface to read a file containing a list of symptoms.
 * It reads each line from the file and adds it to a List of symptoms.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
     * Reads the list of symptoms from the specified file and returns them as a List of Strings.
     * 
     * @return A List of Strings representing the symptoms.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			
			try(BufferedReader reader = new BufferedReader (new FileReader(filepath))) {			
				String line = reader.readLine();
				
				while (line != null) {
					// Adding each line (one symptom) to the result List
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

}
