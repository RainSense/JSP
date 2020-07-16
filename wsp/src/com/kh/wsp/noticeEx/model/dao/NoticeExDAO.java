package com.kh.wsp.noticeEx.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.kh.wsp.noticeEx.model.vo.NoticeEx;

public class NoticeExDAO {
	
	private Properties prop = null;
	
	public NoticeExDAO() throws FileNotFoundException, IOException {
		
		String fileName = NoticeExDAO.class.getResource("/com/kh/wsp/sql/notice/noticeEx-query.properties").getPath();

		prop = new Properties();
		
		prop.load(new FileReader(fileName));
		
		
		
	}
			
	
	
	

	public List<NoticeEx> allListSelect(Connection conn) throws Exception{
		
		Statement stmt = null;
		
		ResultSet rset = null;
		
		List<NoticeEx> list = null;
		
		String query = null;
		
				try {
					
					
					
					
					
					NoticeEx noticEx = null;
					
					
					
					
					
					
				}finally {
					rset.close();
					stmt.close();
					
				}
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
