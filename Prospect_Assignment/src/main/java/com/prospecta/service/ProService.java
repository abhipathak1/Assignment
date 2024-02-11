package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.entity.ProEntity;

@Service
public class ProService {

	private static final String API_URL = "https://api.publicapis.org/entries";

	/**
	 * Fetches APIs by a specified category.
	 * 
	 * @param category The category of APIs to fetch
	 * @return List of ProEntity objects representing APIs in the specified category
	 */
	public List<ProEntity> getApisByCategory(String category) {
		final String uri = API_URL + "?category=" + category;
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> result = restTemplate.getForObject(uri, Map.class);

		List<Map<String, String>> entries = (List<Map<String, String>>) result.get("entries");
		List<ProEntity> apiEntries = new ArrayList<>();

		for (Map<String, String> entry : entries) {
			String title = entry.get("API");
			String description = entry.get("Description");
			apiEntries.add(new ProEntity(title, description));
		}
		return apiEntries;
	}

	public ResponseEntity<Object> AddEntry(ProEntity entry) {
		final String uri = API_URL;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> result = restTemplate.postForEntity(uri, entry, Object.class);

		return result;
	}

}
