package com.reservo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String homePageWelcome() {
		return "Welcome to Home Page";
	}
}
