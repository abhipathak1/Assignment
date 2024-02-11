package com.prospectaTC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<String, String> data = new HashMap<>();
	private static Map<String, Integer> result = new HashMap<>();

	public static void main(String[] args) {

		String file = "src\\Prospecta.csv";

		// Reading data from the CSV file
		readDataFromCSV(file);

		// Evaluating formulas and storing results
		CalculateAndStoreResults();

		// Printing results to the console
		printResultsToConsole();

		// Writing results to the output CSV file
		writeToCSV("src\\Output.csv");
	}

	private static void readDataFromCSV(String file) {
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					data.put(parts[0], parts[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void CalculateAndStoreResults() {
		for (String key : data.keySet()) {
			if (!result.containsKey(key)) {
				int value = evaluateFormula(key);
				result.put(key, value);
			}
		}
	}

	private static void printResultsToConsole() {
		for (String key : data.keySet()) {
			System.out.println(key + ": " + result.get(key));
		}
	}

	private static int evaluateFormula(String key) {
		if (result.containsKey(key)) {
			return result.get(key);
		}

		String value = data.get(key);
		if (value.startsWith("=")) {
			String[] parts = value.substring(1).split("\\+");
			int sum = 0;
			for (String part : parts) {
				if (part.matches("[A-Z][0-9]")) {
					sum += evaluateFormula(part);
				} else {
					sum += Integer.parseInt(part);
				}
			}
			return sum;
		} else {
			return Integer.parseInt(value);
		}
	}

	// Method to write results to a CSV file
	private static void writeToCSV(String file) {
		try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fileWriter)) {

			// Writing each entry to the CSV file
			for (Map.Entry<String, Integer> entry : result.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue());
				writer.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
