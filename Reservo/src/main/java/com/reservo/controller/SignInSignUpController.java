package com.reservo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservo.dto.SignInRequestDto;
import com.reservo.dto.SignInResponseDto;
import com.reservo.dto.SignUpRequest;
import com.reservo.service.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class SignInSignUpController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SignInRequestDto reqDTO) {
		return null;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid SignUpRequest dto) {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));
	}

}
