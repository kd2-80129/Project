package com.reservo.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservo.dao.OwnerDao;
import com.reservo.dto.SignUpRequest;
import com.reservo.entities.OwnerEntity;
import com.reservo.entities.UserRole;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public OwnerEntity findByEmail(String email) {
		
		return ownerDao.findByEmail(email);
	}

	@Override
	public SignUpRequest ownerRegistration(SignUpRequest owner) {
		OwnerEntity ownerEntity = mapper.map(owner, OwnerEntity.class);
		ownerEntity.setRole(UserRole.ROLE_OWNER);
		System.out.println(ownerEntity);
		return mapper.map(ownerDao.save(ownerEntity), SignUpRequest.class);
	}
	
}
