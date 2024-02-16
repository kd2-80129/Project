package com.reservo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservo.entities.ReservationEntity;

public interface ReservationDao extends JpaRepository<ReservationEntity, Long>{

}
