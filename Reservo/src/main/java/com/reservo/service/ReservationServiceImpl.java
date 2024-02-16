package com.reservo.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservo.customexceptions.ResourceNotFoundException;
import com.reservo.dao.ReservationDao;
import com.reservo.dao.RestaurantDao;
import com.reservo.dto.ReservationReqDto;
import com.reservo.entities.ReservationEntity;
import com.reservo.entities.RestaurantEntity;
import com.reservo.entities.UserEntity;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private RestaurantDao restDao;
	
	@Autowired
	private ReservationDao reservDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ReservationEntity makeReservation(Long restId, ReservationReqDto reqDto, UserEntity user) {
		RestaurantEntity rest = restDao.findById(restId).
				orElseThrow(() -> new ResourceNotFoundException("Restaurant Not Found..!!"));
		ReservationEntity reserv = mapper.map(reqDto, ReservationEntity.class);
		reserv.setRestaurants(rest);
		reserv.setUser(user);
		//rest.addReview(reserv);
		return reservDao.save(reserv);
	}

}
