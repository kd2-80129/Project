package com.reservo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservo.dto.UserDTO;
import com.reservo.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;
	// update user details
	// http://host:port/user/{userId} , method=PUT
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable Long userId, @RequestBody @Valid UserDTO dto ){
		System.out.println("in update emp " + userId + " " + dto);
		return ResponseEntity.ok(userService.updateEmployee(userId, dto));
	}
	
}
