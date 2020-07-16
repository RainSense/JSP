package com.btm.better.board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.btm.better.board.model.vo.FreeBoard;

public class FreeBoardDAO {

	private Properties prop = null;
	
	public FreeBoardDAO() throws FileNotFoundException, IOException {
		String fileName = FreeBoardDAO.class
				.getResource("/com/btm/better/sql/fBoard/fBoard-query.properties").getPath();
		prop = new Properties();
		
		prop.load(new FileReader(fileName));
		
		
	}
	

	
	
	public List<FreeBoard> selectAllFboard(Connection conn) throws Exception{
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<FreeBoard> fBoardList = new ArrayList<FreeBoard>();
		
		String query = prop.getProperty("selectAllFboard");
		
		
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			
			FreeBoard fBoard = null;
			
			while(rset.next()) {
				
				int freeBoardNo = rset.getInt("FREEBOARD_NO");
				
				String freeBoardTitle = rset.getString("FREEBOARD_TITLE");
				
				String freeBoardWriter = rset.getString("MEMBER_NM");
				
				String freeBoardTag = rset.getString("FREEBOARD_TAG");
				
				int freeBoardLike = rset.getInt("FREEBOARD_LIKE");
				
				int freeBoardReplyCount = rset.getInt("FREEBOARD_REPLY_COUNT");
				
				int readCount = rset.getInt("READ_COUNT");
				
				Date freeBoardCreateDt = rset.getDate("FREEBOARD_CREATE_DT");
				
				
				fBoard = new FreeBoard(freeBoardNo, freeBoardTitle, freeBoardWriter, freeBoardTag, readCount, freeBoardCreateDt, freeBoardLike, freeBoardReplyCount);
				
				fBoardList.add(fBoard);
				
				
				
				
			}
			
			
			
			
			
			
		}finally {
			
			
			
			
		}
		
		
		
		
		
		return fBoardList;
	}
	
	
	
	
	
	
	
	

}
