package com.reservo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reservo.dto.SignInRequestDto;
import com.reservo.dto.SignUpRequest;
import com.reservo.dto.UserReqDto;
import com.reservo.entities.UserEntity;
import com.reservo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SignInRequestDto reqDto, HttpServletRequest req) {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		UserEntity user = userService.findByEmail(reqDto.getEmail());
		
		if(user != null) {
			if(!(user.getPassword().equals(reqDto.getPassword()))) {
				String error = "Wrong Password!!";
				return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("curr_user", user);
				return new ResponseEntity<UserEntity>(user, responseHeaders, HttpStatus.OK);
			}
		}
		String error = "User Does not Exist!!";
		return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
	}
	
	//User registration
	//localhost:8080/user/signup
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid SignUpRequest dto) {
		System.out.println("in sign up " + dto);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		UserEntity user = userService.findByEmail(dto.getEmail());
		
		if(user != null) {
			String error = "Email Already Exists!!";
			return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> profileUpdate(@PathVariable Long userId,@RequestBody @Valid UserReqDto reqDto){
		
		return ResponseEntity.ok(userService.updateProfile(userId, reqDto));
	}
}
