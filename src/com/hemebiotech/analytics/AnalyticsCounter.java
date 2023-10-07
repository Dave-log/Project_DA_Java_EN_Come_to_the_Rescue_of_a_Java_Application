package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(String filepath){
		
		this.reader = new ReadSymptomDataFromFile(filepath);
		this.writer = new WriteSymptomDataToFile();
	}
	
	public List<String> getSymptoms(){
		
		List<String> listSymptoms = reader.GetSymptoms();
		return listSymptoms;
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		
		Map<String, Integer> mapSymptoms = new HashMap<>();
		
		for(String symptom: symptoms) {
			mapSymptoms.putIfAbsent(symptom, 0);
			mapSymptoms.put(symptom, mapSymptoms.get(symptom) + 1);
		}
		
		return mapSymptoms;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms, String outputPath) {
		
		writer.writeSymptoms(symptoms, outputPath);
	}
}
