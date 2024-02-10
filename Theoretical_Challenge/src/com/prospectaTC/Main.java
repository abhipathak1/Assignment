package com.prospectaTC;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, String> data = new HashMap<>();
    private static Map<String, Integer> result = new HashMap<>();

    public static void main(String[] args) {

        data.put("A1", "5");
        data.put("A2", "7");
        data.put("A3", "9");
        data.put("B1", "3");
        data.put("B2", "8");
        data.put("B3", "=4+5");
        data.put("C1", "=5+A1");
        data.put("C2", "=A2+B2");
        data.put("C3", "=C2+B3");

        for (String key : data.keySet()) {
            if (!result.containsKey(key)) {
                int value = evaluateFormula(key);
                result.put(key, value);
            }
        }

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
}
