package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * The AnalyticsCounter class provides functionality to analyze and process symptom data.
 * It uses a reader and a writer,
 * and includes methods for obtaining, counting, sorting, and writing symptoms.
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	 /** 
     * @param reader The ISymptomReader to read symptom data.
     * @param writer The ISymptomWriter to write analyzed data.
     */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
     * @return A List of Strings representing symptoms.
     */
	public List<String> getSymptoms(){
		
		return reader.getSymptoms();
	}
	
	/**
     * Counts the occurrences of each symptom in the provided list and returns a Map
     * with symptoms as keys and their counts as values.
     * 
     * @param symptoms A List of Strings representing symptoms.
     * @return A Map<String, Integer> with symptoms and their counts.
     */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		
		final Map<String, Integer> symptomsByCounts = new HashMap<>();
		
		for(String symptom: symptoms) {
			// If symptom is already mapped, the "putIfAbstent" method will do nothing.
			symptomsByCounts.putIfAbsent(symptom, 0);
			symptomsByCounts.put(symptom, symptomsByCounts.get(symptom) + 1);
		}
		
		return symptomsByCounts;
	}
	
	/**
     * Sorts the provided Map of symptoms in alphabetic order (by key).
     * 
     * @param symptomsByCounts A Map<String, Integer> with symptoms and their counts.
     * @return A sorted Map<String, Integer> in alphabetic order.
     */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsByCounts){
		
		return new TreeMap<>(symptomsByCounts);
	}
	
	/**
     * Writes the provided Map of symptoms and their counts to the specified output file.
     * 
     * @param symptomsByCounts A Map<String, Integer> with symptoms and their counts.
     * @param outputPath The path to the output file where the data will be written.
     */
	public void writeSymptoms(Map<String, Integer> symptomsByCounts, String outputPath) {
		
		writer.writeSymptoms(symptomsByCounts, outputPath);
	}
	
}
