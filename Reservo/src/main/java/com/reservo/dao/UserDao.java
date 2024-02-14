package com.reservo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
