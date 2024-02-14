package com.reservo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.RestaurantEntity;

public interface RestaurantDao extends JpaRepository<RestaurantEntity, Long>{

	List<RestaurantEntity> findByCityId(Long id);
}
