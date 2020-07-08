package com.ks.bm.member.model.DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.ks.bm.member.model.vo.Member;

public class MemberDAO {

	
	private Properties prop = null;
	
		public MemberDAO () throws FileNotFoundException, IOException {
	
			String fileName = MemberDAO.class
					.getResource("/com/ks/bm/sql/member/memberQuery.properties").getPath();
			prop = new Properties();
			
			prop.load(new FileReader(fileName));
			
			
		}
	
	
	
	
	
	public int signUp(Member mem, Connection conn) throws Exception{
		
		String query = prop.getProperty("signUp");
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mem.getMemberName());
			pstmt.setString(2, mem.getMemberEmail());
			pstmt.setString(3, mem.getMemberPwd());
			
			
			result = pstmt.executeUpdate();
			
			
			
			
			
		}finally {
			
			
			
			
			
			if(pstmt!=null) {
				pstmt.close();
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}





	public Member checkId(Member mem, Connection conn) throws Exception{
		
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		
		Member loginMember = null;
		
		String query = prop.getProperty("checkId");
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mem.getMemberName());
			
			rset = pstmt.executeQuery();
			
			System.out.println(mem.getMemberName()+"툭툭");
			
			
			System.out.println(mem.getMemberPwd());
			
			if (rset.next()) {
				
				String memberName = rset.getString("MEMBER_NAME");
				String memberEmail = rset.getString("EMAIL");
				String memberGrade = rset.getString("MEMBER_GRADE");
				
				loginMember = new Member(memberEmail, memberName, memberGrade);
				
				System.out.println("이건돼");
				
			}
			
			if(loginMember == null) {
				System.out.println("아얏");
			}
			
			
			
			
			
			
			
			
			
		}finally {
			
			if(rset!=null) {
				rset.close();
				pstmt.close();
			}
			
			
			
		}
		
		
		
		
		
		return loginMember;
	}

}
