package com.yk.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk.statement.vo.Tourist;

public class TouristDao {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "KYK03";
	private final String PASSWORD = "KYK031234";
	
	public int book(Tourist tourist) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				       INSERT
				         INTO
				              TB_TOURIST
				       VALUES
				              (
				              SEQ_USERNO.NEXTVAL      
				            , ?
				            , ?
				            , ?
				            , ?
				            , SYSDATE
				              )  
					 """;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tourist.getTouristName());
			pstmt.setString(2, tourist.getTouristNo());
			pstmt.setString(3, tourist.getPhone());
			pstmt.setString(4, tourist.getDestination());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	return result; 	
	}
	
	public void findAll() {
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		List<Tourist> tourist = new ArrayList();
		
		Class
		
	}

}
