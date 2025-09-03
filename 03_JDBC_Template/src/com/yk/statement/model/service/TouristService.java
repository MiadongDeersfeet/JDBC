package com.yk.statement.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.yk.statement.model.dao.TouristDao;
import com.yk.statement.vo.Tourist;

public class TouristService {
	private Connection conn = null;
	
	public TouristService() {
		conn = JDBCTemplate.getConnection();
	}
	
	public int book(Tourist tourist) {
		
		int result = new TouristDao().book(conn, tourist);
		
		return result;
	}
	
}
