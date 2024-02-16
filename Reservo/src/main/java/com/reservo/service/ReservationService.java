package com.reservo.service;

import com.reservo.dto.ReservationReqDto;
import com.reservo.entities.ReservationEntity;
import com.reservo.entities.UserEntity;

public interface ReservationService {

	ReservationEntity makeReservation(Long restId, ReservationReqDto reqDto, UserEntity user);

}
