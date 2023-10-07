package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms, String outputPath) {
		
		try (FileWriter writer = new FileWriter (outputPath)) {
			for(Map.Entry<String, Integer> m : symptoms.entrySet()) {
				writer.write(m.getKey() + ": " + m.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
