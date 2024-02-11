package com.reservo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByEmail(String email);
}
