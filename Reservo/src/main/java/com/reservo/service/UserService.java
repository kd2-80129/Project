package com.reservo.service;

import com.reservo.dto.SignUpRequest;
import com.reservo.dto.UserReqDto;
import com.reservo.entities.UserEntity;

public interface UserService {
	
	SignUpRequest userRegistration(SignUpRequest user);
	
	UserEntity findByEmail(String email);
	
	UserEntity updateProfile(Long userId, UserReqDto reqDto);
}
