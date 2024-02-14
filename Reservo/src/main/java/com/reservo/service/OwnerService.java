package com.reservo.service;

import javax.validation.Valid;

import com.reservo.dto.SignUpRequest;
import com.reservo.entities.OwnerEntity;

public interface OwnerService {

	OwnerEntity findByEmail(String email);

	SignUpRequest ownerRegistration(@Valid SignUpRequest dto);
	
}
