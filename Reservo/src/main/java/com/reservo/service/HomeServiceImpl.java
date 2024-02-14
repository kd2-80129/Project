package com.reservo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservo.dao.CityDao;
import com.reservo.dao.HomeDao;
import com.reservo.entities.CityEntity;
import com.reservo.entities.StateEntity;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao; 
	
	@Autowired
	private CityDao cityDao; 
	
	@Override
	public List<StateEntity> getAllStates() {
		
		return homeDao.findAll();
	}

	@Override
	public List<CityEntity> getAllCities(Long stateId) {
		
		return cityDao.findByStateId(stateId);
	}

}
