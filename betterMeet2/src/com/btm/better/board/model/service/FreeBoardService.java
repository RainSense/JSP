package com.btm.better.board.model.service;

import static com.btm.better.common.DBCP.getConnection;

import java.sql.Connection;
import java.util.List;

import com.btm.better.board.model.dao.FreeBoardDAO;
import com.btm.better.board.model.vo.FreeBoard;


public class FreeBoardService {
	
	
	FreeBoardDAO dao = null;
	
	public FreeBoardService() throws Exception{
		
		dao = new FreeBoardDAO();
	}
	

	
	
	
	
	public List<FreeBoard> selectAllFboard() throws Exception{
		
		
		Connection conn = getConnection();
		
		List<FreeBoard> fboardList = null;
		
		try {
			
			fboardList = dao.selectAllFboard(conn);
			
			
		}finally {
			conn.close();
		}
		
		
		
		
		
		
		return fboardList;
	}

}
