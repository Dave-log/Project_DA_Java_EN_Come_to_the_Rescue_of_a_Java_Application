package com.hemebiotech.analytics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Reads symptom data, performs a basic map-reduce, and writes the results to an output file.
 * 
 * @author David G.
 */
public class Main {

	public static void main(String[] args) {
		
		Path symptomFilePath = Paths.get("resources/symptoms.txt");
		Path outputFilePath = Paths.get("resources/result.out");
		ISymptomReader reader = new ReadSymptomDataFromFile(symptomFilePath);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		
		// Obtaining a list of symptoms from the reader
		List<String> listSymptoms = analyticsCounter.getSymptoms();
		
		// Counting occurrences of each symptom and mapping them
		Map<String, Integer> symptomsByCounts = analyticsCounter.countSymptoms(listSymptoms);
		
		// Sorting the symptoms in alphabetic order
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsByCounts);
		
		// Writing the sorted symptoms to an output file
		analyticsCounter.writeSymptoms(sortedSymptoms, outputFilePath);
	}
	
}
