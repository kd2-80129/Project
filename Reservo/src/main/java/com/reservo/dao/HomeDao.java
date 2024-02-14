package com.reservo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.StateEntity;

public interface HomeDao extends JpaRepository<StateEntity, Long>{
 
}
