package com.reservo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservo.dto.RestaurantReqDto;
import com.reservo.entities.OwnerEntity;
import com.reservo.entities.RestaurantEntity;
import com.reservo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/{cityId}")
	public ResponseEntity<?> getAllRestaurantsBByCityId(@PathVariable @Valid Long cityId){
		return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getAllRestaurantsByCityId(cityId));
	}
	
	@PostMapping("/add/{cityId}")
	public ResponseEntity<?> addRestaurant(@RequestBody @Valid RestaurantReqDto reqDto, @PathVariable Long cityId,HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		OwnerEntity owner = (OwnerEntity) session.getAttribute("curr_owner");
		System.out.println(owner);
		
		if(owner != null) {
			restaurantService.addRestaurant(reqDto, owner.getId(), cityId);
		}
		String msg = "Restaurant Added...!!";
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}
