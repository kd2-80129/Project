package com.reservo.service;

import javax.validation.Valid;

import com.reservo.dto.SignUpRequest;
import com.reservo.dto.UserDTO;

public interface UserService {
	
	SignUpRequest userRegistration(SignUpRequest user);

	UserDTO updateEmployee(Long userId, @Valid UserDTO dto);
}
