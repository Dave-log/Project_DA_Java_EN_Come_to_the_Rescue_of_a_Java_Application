package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write mapped symptoms to a file located at path
 */
public interface ISymptomWriter {

	/**
     * Writes the provided Map of symptoms and their counts to the specified path.
     * 
     * @param symptoms A Map<String, Integer> with symptoms and their counts.
     * @param path The path to the file where the symptom data will be written.
     */
	public void writeSymptoms(Map<String, Integer> symptoms, String path);
}
