package com.yk.statement.controller;

import java.util.List;

import com.yk.statement.model.dao.TouristDao;
import com.yk.statement.vo.Tourist;

public class TouristController {
	
	public int book(String touristName, String touristNo, String phone, String destination) {
		// 1. 데이터 가공하기
		Tourist tourist = new Tourist(touristName, touristNo, phone, destination);
		// 2. 요청하기
		int result = new TouristDao().book(tourist);
		
		return result;
	}

	public List<Tourist> findAll() {
		// 1. 전달받은 값이 없네!
		List<Tourist> tourists = new TouristDao().findAll();
		
		return tourists;
	}
}
