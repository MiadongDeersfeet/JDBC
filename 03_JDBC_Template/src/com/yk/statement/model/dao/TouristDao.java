package com.yk.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.yk.statement.vo.Tourist;

public class TouristDao {
	
	public int book(Connection conn, Tourist tourist) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = """
                       INSERT
                         INTO
                              TB_TOURIST
                       VALUES      
                              ?
                            , ?
                            , ?
                            , ?
					 """;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tourist.getTouristName());
			pstmt.setString(2, tourist.getTouristNo());
			pstmt.setString(3, tourist.getPhone());
			pstmt.setString(4, tourist.getDestination());
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}

}
