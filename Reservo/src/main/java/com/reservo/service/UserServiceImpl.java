package com.reservo.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservo.customexceptions.ResourceNotFoundException;
import com.reservo.dao.UserDao;
import com.reservo.dto.SignUpRequest;
import com.reservo.dto.UserReqDto;
import com.reservo.entities.UserEntity;
import com.reservo.entities.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public SignUpRequest userRegistration(SignUpRequest user) {
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		userEntity.setRole(UserRole.ROLE_CUSTOMER);
		System.out.println(userEntity);
		return mapper.map(userDao.save(userEntity), SignUpRequest.class);
	}

	@Override
	public UserEntity findByEmail(String email) { 
		return userDao.findByEmail(email);
	}

	@Override
	public UserEntity updateProfile(Long userId, UserReqDto reqDto) {
		UserEntity user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found..!!"));
		mapper.map(reqDto, user);
		return user;
	}

}
