package com.prospectaTC;

import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<String, String> data = new HashMap<>();
	private static Map<String, Integer> result = new HashMap<>();

	public static void main(String[] args) {

		populateEvaluateAndPrint();
	}

	private static void populateEvaluateAndPrint() {
		data.put("A1", "5");
		data.put("A2", "7");
		data.put("A3", "9");
		data.put("B1", "3");
		data.put("B2", "8");
		data.put("B3", "=4+5");
		data.put("C1", "=5+A1");
		data.put("C2", "=A2+B2");
		data.put("C3", "=C2+B3");

		for (String cell : data.keySet()) {
			if (!result.containsKey(cell)) {
				int value = evaluateCell(cell);
				result.put(cell, value);
			}
		}

		for (String cell : data.keySet()) {
			System.out.println(cell + ": " + result.get(cell));
		}
	}

	private static int evaluateCell(String cell) {
		if (result.containsKey(cell)) {
			return result.get(cell);
		}

		String formula = data.get(cell);
		if (formula.startsWith("=")) {
			String[] parts = formula.substring(1).split("\\+");
			int sum = 0;
			for (String part : parts) {
				if (part.matches("[A-Z]\\d")) {
					sum += evaluateCell(part);
				} else {
					sum += Integer.parseInt(part);
				}
			}
			return sum;
		} else {
			return Integer.parseInt(formula);
		}
	}
}
