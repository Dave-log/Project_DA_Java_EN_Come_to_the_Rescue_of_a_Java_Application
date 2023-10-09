package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class implements the ISymptomWriter interface to write the content of a Map
 * containing (Key, Value) pairs representing symptoms and their corresponding counts to a file.
 * Each entry in the Map is written to the file in the format "Key: Value".
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
     * Writes the symptoms and their counts from the given Map to the specified output file.
     * Each entry is written in the format "Key: Value".
     * 
     * @param symptomsByCounts The Map containing symptoms (Keys) and their counts (Values).
     * @param outputPath The path to the output file where the data will be written.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
	@Override
	public void writeSymptoms(Map<String, Integer> symptomsByCounts, String outputPath) {
		// Writing each (Key, Value) pair to the file
		try (FileWriter writer = new FileWriter (outputPath)) {		
			for(Map.Entry<String, Integer> m : symptomsByCounts.entrySet()) {
				writer.write(m.getKey() + ": " + m.getValue() + "\n");
			}

		} catch (IOException e) {
			System.err.println("Error while writing into file " + e.getMessage() + " caused by " + e.getCause());
		}
		System.out.println("Writing successfull.");
	}

}
