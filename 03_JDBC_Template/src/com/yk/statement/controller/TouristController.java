package com.yk.statement.controller;

import com.yk.statement.model.service.TouristService;
import com.yk.statement.vo.Tourist;

public class TouristController {
	
	public int book(String touristName, String touristNo, String phone, String destination) {
		
		Tourist tourist = new Tourist(touristName, touristNo, phone, destination);
		
		int result = new TouristService().book(tourist);
		
		return result;
	}
}
