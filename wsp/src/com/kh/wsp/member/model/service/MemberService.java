package com.kh.wsp.member.model.service;



import static com.kh.wsp.common.DBCP.getConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import com.kh.wsp.member.model.dao.MemberDAO;
import com.kh.wsp.member.model.vo.Member;






public class MemberService {

	
	
	private MemberDAO dao;
	
	public MemberService() throws FileNotFoundException, IOException {
		dao = new MemberDAO();
		
	}


	
	/** 로그인용 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception{
		// 커넥션 얻어오기
		Connection conn = getConnection();
		
		
		
		
		// dao 호출
		Member loginMember = dao.loginMember(conn,member);
		// 커넥션 반환
		conn.close();
		
		// 결과 반환
		return loginMember;
		
	}



	
	
	/** 회원 가입용 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn,member);
		
		// 트랜잭션 처리
		
		if (result>0) {
		conn.commit();
		}else {
			conn.rollback();
		}
		
		conn.close();
		
		
		
		
		
		return result;
	}



	public int idDupCheck(String id) throws Exception{
	
		Connection conn = getConnection();
		
		
		int result = dao.idDupCheck(id,conn);
		
		
		conn.close();
		
		
		
		
		
		
		
		return result;
	}



	public int updateMember(Member member) throws Exception{
		
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = dao.updateMember(member,conn);
			
			
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



	public int updatePwd(Member member, String newPwd) throws Exception{
		
		
		Connection conn = getConnection();
		
		
		// 1. 현재 비밀번호 일치 여부 확인
		int result = dao.checkPwd(conn, member);
		
		
		if(result > 0) { // 현재 비밀번호 일치
			// 2. 일치할 경우 비밀번호 수정


			// member객체 재활용(
			member.setMemberPwd(newPwd);
			
			result = dao.updatePwd(conn, member);
			
			if(result > 0)	conn.commit();
			else			conn.rollback();
			
			
		}else { // 현재 비밀번호가 일치하지 않는 경우
			
			
			result = -1;  // 비밀번호 불일치 코드로 -1 사용
			
		}
		
		
		
		
		
		
		
		
		return result;
	}



	/**
	 * @param member
	 * @param newPwd
	 * @return result
	 * @throws Exception
	 */
	public int updatePwd2(Member member, String newPwd) throws Exception{

		Connection conn = getConnection();
		
		
		// 1. 현재 비밀번호 일치 여부 확인
		int result = dao.updatePwd(conn, member,newPwd);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		
		
		conn.close();
		
		
		
		
		
		
		
		return result;
	}



	public int seccessionMember(Member member) throws Exception{

		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.checkPwd(conn, member);
			
			if(result>0) {
				
				result = dao.seccesionMember(conn,member);
				conn.commit();
				
				
			}else {
				result = -1;
				conn.rollback();
			}
			
			
		}finally {
			
			
		}
		

		
		
		return result;
	}



	
	
	/** 회원 정보 조회 Service
	 * @param memberId
	 * @return selectMember
	 * @throws Exception
	 */
	public Member selctMember(String memberId) throws Exception {
		Connection conn = getConnection();
		
		Member selectMember =dao.selectMember(conn, memberId);
		
		conn.close();
		
		return selectMember;
	}

}











