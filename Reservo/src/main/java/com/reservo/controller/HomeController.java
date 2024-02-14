package com.reservo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reservo.entities.CityEntity;
import com.reservo.entities.StateEntity;
import com.reservo.service.HomeService;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeService homeService;

	@GetMapping
	public List<StateEntity> homePageWelcome() {
		return homeService.getAllStates();
	}
	
	@GetMapping("/{stateId}")
	public List<CityEntity> getAllCities(@PathVariable Long stateId){
		return homeService.getAllCities(stateId);
	}
}
