package com.kh.wsp.noticeEx.model.service;

import static com.kh.wsp.common.DBCP.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.wsp.noticeEx.model.dao.NoticeExDAO;
import com.kh.wsp.noticeEx.model.vo.NoticeEx;

public class NoticeExService {
	
	NoticeExDAO dao = null;
	
	public NoticeExService() throws Exception{
		
		dao = new NoticeExDAO();
		
		
	}
	
	

	public List<NoticeEx> allListSelect() throws Exception{

		
		Connection conn = getConnection();
		
		
		List<NoticeEx> list = null;
		
		
		try {
			
			list = new ArrayList<NoticeEx>();
			
			list = dao.allListSelect(conn);
			
			
			
		}finally {
			conn.close();
			
		}
		
		
		
		
		
		
		
		
		return null;
	}

}









