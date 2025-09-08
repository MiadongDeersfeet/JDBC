package com.yk.statement.controller;

import java.util.List;

import com.yk.statement.model.dto.TouristDTO;
import com.yk.statement.model.service.TouristService;
import com.yk.statement.vo.Tourist;

public class TouristController {
	
	public int book(String touristName, String touristNo, String phone, String destination) {
		
		Tourist tourist = new Tourist(touristName, touristNo, phone, destination);
		
		int result = new TouristService().book(tourist);
		
		return result;
	}
	
	public List<Tourist> findAll() {
		List<Tourist> tourists = new TouristService().findAll();
		return tourists;
		
	}
	
	public Tourist findByPhone(String phoneNo) {
		Tourist tourist = new TouristService().findByPhone(phoneNo);
		return tourist;
	}
	
	
	public int updateDestination(String phoneNo, String newDestination) {
		TouristDTO td = new TouristDTO(phoneNo, newDestination);
		int result = new TouristService().updateDestination(td);
		return result;
	}
	
	public int cancelTour(String name, String touristNo) {
		Tourist tourist = new Tourist(name, touristNo);
		
		int result = new TouristService().cancelTour(tourist);
		return result;
	}
}
