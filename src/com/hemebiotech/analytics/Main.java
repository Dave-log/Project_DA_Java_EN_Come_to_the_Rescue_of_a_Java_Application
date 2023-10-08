package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Reads symptom data, performs a basic map-reduce, and writes the results to an output file.
 * 
 * @author David G.
 */
public class Main {

	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("resources/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		
		// Obtaining a list of symptoms from the reader
		List<String> listSymptoms = analyticsCounter.getSymptoms();
		// Counting occurrences of each symptom and mapping them
		Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(listSymptoms);
		// Sorting the symptoms in alphabetic order
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
		// Writing the sorted symptoms to an output file
		analyticsCounter.writeSymptoms(sortedSymptoms, "result.out");
	}

}
