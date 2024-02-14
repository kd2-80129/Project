package com.reservo.service;

import java.util.List;

import javax.validation.Valid;

import com.reservo.dto.RestaurantReqDto;
import com.reservo.entities.RestaurantEntity;

public interface RestaurantService {

	List<RestaurantEntity> getAllRestaurantsByCityId(@Valid Long cityId);

	RestaurantEntity addRestaurant(@Valid RestaurantReqDto reqDto, Long id, Long cityIdLong);

}
