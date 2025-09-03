package com.yk.statement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.yk.statement.model.dto.TouristDTO;
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
                              (
                              SEQ_TOURIST_ID.NEXTVAL     
                            , ?
                            , ?
                            , ?
                            , ?
                            , SYSDATE
                              )
					 """;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tourist.getTouristName());
			pstmt.setString(2, tourist.getTouristNo());
			pstmt.setString(3, tourist.getPhone());
			pstmt.setString(4, tourist.getDestination());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}
	
	public List<Tourist> findAll(Connection conn) {
		List<Tourist> tourists = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = """
					   SELECT
					          TOURIST_ID
					        , TOURIST_NAME
					        , TOURIST_NO
					        , PHONE
					        , DESTINATION
					        , ENROLL_DATE
					     FROM
					          TB_TOURIST
					    ORDER
					       BY
					          ENROLL_DATE DESC            
				     """;

		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Tourist tourist = new Tourist(rset.getInt("TOURIST_ID")
						                     ,rset.getString("TOURIST_NAME")
						                     ,rset.getString("TOURIST_NO")
						                     ,rset.getString("PHONE")
						                     ,rset.getString("DESTINATION")
						                     ,rset.getDate("ENROLL_DATE"));
				tourists.add(tourist);
			}
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		
		return tourists;
	}
	
	public Tourist findByPhone(Connection conn, String phoneNo) {
		Tourist tourist = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				       SELECT
				              TOURIST_ID
				            , TOURIST_NAME
				            , TOURIST_NO
				            , PHONE
				            , DESTINATION
				            , ENROLL_DATE
				         FROM
				              TB_TOURIST
				        WHERE
				              PHONE = ?
				        ORDER
				           BY
				              ENROLL_DATE DESC                  
				 	 """;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNo);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				tourist = new Tourist(rset.getInt("TOURIST_ID")
						                     ,rset.getString("TOURIST_NAME")
						                     ,rset.getString("TOURIST_NO")
						                     ,rset.getString("PHONE")
						                     ,rset.getString("DESTINATION")
						                     ,rset.getDate("ENROLL_DATE"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
	
		return tourist;
	}
	
	public int updateDestination(Connection conn, TouristDTO td) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = """
				       UPDATE
				              TB_TOURIST
				          SET
				              DESTINATION = ?
				        WHERE PHONE = ?
				     """;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, td.getNewDestination());
			pstmt.setString(2, td.getPhone());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
		
	}
	
	public int cancelTour(Connection conn, Tourist tourist) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = """
				       DELETE
				         FROM    
				              TB_TOURIST
				        WHERE 
				              TOURIST_NAME = ?
				          AND
				              TOURIST_NO = ?      
					 """;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tourist.getTouristName());
			pstmt.setString(2, tourist.getTouristNo());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

		
	}

}
