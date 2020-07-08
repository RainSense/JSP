package com.ks.bm.member.model.service;

import com.ks.bm.member.model.DAO.MemberDAO;
import com.ks.bm.member.model.vo.Member;

import static com.ks.bm.common.DBCP.getConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

public class MemberService {
	
	
	private MemberDAO dao;
	
	public MemberService() throws FileNotFoundException, IOException {
		
		
		dao = new MemberDAO();
		
	}
	
	
	
	
	
	public int signUp(Member mem) throws Exception{
		
		
		Connection conn = getConnection();
		
		int result = 0;
		
		
		try {
			
			
			result = dao.signUp(mem,conn);
			
			
			
			
		}finally {
			
			if(result > 0) {
				
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
			
		}
		
		
		conn.close();
		
		
		
		
		
		
		
		
		
		
		return result;
	}





	public Member checkId(Member mem) throws Exception{
	
		
		Connection conn = getConnection();
		
		
	Member	loginMember = dao.checkId(mem, conn);
		
		
		
		conn.close();
		
		
		
		
		
		
		
		
		return loginMember;
	}

}













