package com.reservo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.CityEntity;

public interface CityDao extends JpaRepository<CityEntity, Long>{
		List<CityEntity> findByStateId(Long stateId);
}
