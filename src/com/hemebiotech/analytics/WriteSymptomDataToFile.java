package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	public void writeSymptoms(Map<String, Integer> symptomsByCounts, Path outputPath) {
		// Writing each (Key, Value) pair to the file
		try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {	
			
			for(Map.Entry<String, Integer> m : symptomsByCounts.entrySet()) {
				writer.write(m.getKey() + ": " + m.getValue() + "\n");
			}
			System.out.println("Writing successfull.");
			
		} catch (IOException e) {
			System.err.println("Error while writing into file " + e.getMessage() + " caused by " + e.getCause());
		}
	}

}
