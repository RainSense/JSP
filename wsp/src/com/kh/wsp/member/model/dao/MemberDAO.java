package com.kh.wsp.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.kh.wsp.member.model.vo.Member;

public class MemberDAO {

	private Properties prop = null;
	
	public MemberDAO() throws FileNotFoundException, IOException {
		String fileName = MemberDAO.class
				.getResource("/com/kh/wsp/sql/member/member-query.properties").getPath();
		prop = new Properties();
		
		prop.load(new FileReader(fileName));
		
		
	}
	
	
	
	
	/** 로그인용 DAO
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception{
	
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		Member loginMember = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new Member(						
						rset.getString("MEMBER_ID"),
						rset.getString("MEMBER_NM"),
						rset.getString("MEMBER_PHONE"),
						rset.getString("MEMBER_EMAIL"),
						rset.getString("MEMBER_ADDR"),
						rset.getString("MEMBER_INTEREST"),
						rset.getString("MEMBER_GRADE")
						);
						
						
			}
			
			
			
		}finally {
			rset.close();
			pstmt.close();
		}
		
		
		
		return loginMember;
		
		
	}




	/** 회원 가입용 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		
		String query = prop.getProperty("signUp");
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(query);	
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			pstmt.setString(7, member.getMemberInterest());
			
			
			 result = pstmt.executeUpdate();
			
			
			
			
		}finally {
			if(pstmt!=null)
			pstmt.close();
			
		}
		
		
		
		
		return result;
	}




	public int idDupCheck(String id, Connection conn) throws Exception{
		
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("idDupCheck");
		int result = 0;
		
		ResultSet rset = null;
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			
			pstmt.setString(1, id);
			
			
			rset = pstmt.executeQuery();
			
			

			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
			
			
		}finally {
			
			if(pstmt!= null) {
				pstmt.close();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}




	public int updateMember(Member member, Connection conn) throws Exception{

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			
			pstmt.setString(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberAddress());
			pstmt.setString(4, member.getMemberInterest());
			pstmt.setString(5, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
			
			
			
			
			
			
		}finally {
			
			
			pstmt.close();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}

	
	
	
	
}
