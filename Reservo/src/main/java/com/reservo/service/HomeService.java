package com.reservo.service;

import java.util.List;
import com.reservo.entities.CityEntity;
import com.reservo.entities.StateEntity;


public interface HomeService {
	List<StateEntity> getAllStates();
	
	List<CityEntity> getAllCities(Long stateId);
}
