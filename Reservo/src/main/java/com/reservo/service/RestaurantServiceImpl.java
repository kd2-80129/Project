package com.reservo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservo.customexceptions.ResourceNotFoundException;
import com.reservo.dao.CityDao;
import com.reservo.dao.OwnerDao;
import com.reservo.dao.RestaurantDao;
import com.reservo.dto.RestaurantReqDto;
import com.reservo.entities.CityEntity;
import com.reservo.entities.OwnerEntity;
import com.reservo.entities.RestaurantEntity;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public List<RestaurantEntity> getAllRestaurantsByCityId(@Valid Long cityId) {
		
		return restaurantDao.findByCityId(cityId);
	}

	@Override
	public RestaurantEntity addRestaurant(@Valid RestaurantReqDto reqDto, Long id, Long cityId) {
		RestaurantEntity restaurant = mapper.map(reqDto, RestaurantEntity.class);
		CityEntity city = cityDao.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City Not Found...!!"));
		restaurant.setCity(city);
		OwnerEntity owner = ownerDao.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Resource not found") );
		restaurant.setOwner(owner);
		return restaurantDao.save(restaurant);
	}

}
