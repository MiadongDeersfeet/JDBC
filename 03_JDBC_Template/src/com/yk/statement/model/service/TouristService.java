package com.yk.statement.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.yk.statement.model.dao.TouristDao;
import com.yk.statement.model.dto.TouristDTO;
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
	
	public List<Tourist> findAll() {
		List<Tourist> tourists = new TouristDao().findAll(conn);
		JDBCTemplate.close(conn);
		return tourists;
	}
	
	public Tourist findByPhone(String phoneNo) {
		Tourist tourist = new TouristDao().findByPhone(conn, phoneNo);
		JDBCTemplate.close(conn);
		return tourist;
	}
	
	public int updateDestination(TouristDTO td) {
		int result = new TouristDao().updateDestination(conn, td);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int cancelTour(Tourist tourist) {
		int result = new TouristDao().cancelTour(conn, tourist);
		JDBCTemplate.close(conn);
		return result;
	}
}
