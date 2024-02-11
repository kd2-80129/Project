package com.reservo.service;

import com.reservo.dto.SignUpRequest;

public interface UserService {
	
	SignUpRequest userRegistration(SignUpRequest user);
}
