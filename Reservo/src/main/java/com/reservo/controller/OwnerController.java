package com.reservo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reservo.dto.SignInRequestDto;
import com.reservo.dto.SignUpRequest;
import com.reservo.entities.OwnerEntity;
import com.reservo.service.OwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin("*")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinOwner(@RequestBody @Valid SignInRequestDto reqDto, HttpServletRequest req) {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		OwnerEntity owner = ownerService.findByEmail(reqDto.getEmail());
		
		if(owner != null) {
			if(!(owner.getPassword().equals(reqDto.getPassword()))) {
				String error = "Wrong Password!!";
				return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("curr_owner", owner);
				return new ResponseEntity<OwnerEntity>(owner, responseHeaders, HttpStatus.OK);
			}
		}
		String error = "User Does not Exist!!";
		return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
	}
	
	//Owner registration
	//localhost:8080/owner/signup
	@PostMapping("/signup")
	public ResponseEntity<?> ownerSignup(@RequestBody @Valid SignUpRequest dto) {
		System.out.println("in sign up " + dto);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		OwnerEntity user = ownerService.findByEmail(dto.getEmail());
		
		if(user != null) {
			String error = "Email Already Exists!!";
			return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.ownerRegistration(dto));
	}
}
