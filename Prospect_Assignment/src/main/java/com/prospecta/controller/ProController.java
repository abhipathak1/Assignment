package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entity.ProEntity;
import com.prospecta.service.ProService;

@RestController
public class ProController {

	@Autowired
	private ProService proService;

	/**
	 * Endpoint to fetch APIs by category.
	 * 
	 * @param category The category of APIs to fetch
	 * @return List of ProEntity objects representing APIs in the specified category
	 */
	@GetMapping("/api/byCategory")
	public List<ProEntity> getApisByCategory(@RequestParam String category) {
		return proService.getApisByCategory(category);
	}

}
