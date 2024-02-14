package com.reservo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.OwnerEntity;

public interface OwnerDao extends JpaRepository<OwnerEntity, Long>{
	OwnerEntity findByEmail(String email);
}