package com.reservo.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservo.custom_exceptions.ApiException;
import com.reservo.custom_exceptions.ResourceNotFoundException;
import com.reservo.dao.UserDao;
import com.reservo.dto.SignUpRequest;
import com.reservo.dto.UserDTO;
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
	public UserDTO updateEmployee(Long userId, @Valid UserDTO dto) {
		UserEntity user = userDao.findById(userId)
				                 .orElseThrow(()-> new ResourceNotFoundException("invalid user ID , user not found !!!!\""));
		if(dto.getPassword().equals(user.getPassword())) {
			user =  mapper.map(dto, UserEntity.class);
			System.out.println("after mapping " + user);
			UserEntity savedUser = userDao.save(user);
            return mapper.map(savedUser, UserDTO.class);
		}
		throw new ApiException("Passwords don't match");
	}

}
