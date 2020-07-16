package com.kh.wsp.notice.model.service;

import static com.kh.wsp.common.DBCP.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.wsp.notice.model.dao.NoticeDAO;
import com.kh.wsp.notice.model.vo.Notice;

public class NoticeService {

	private NoticeDAO dao;
	
	public NoticeService() throws Exception{
		dao = new NoticeDAO();
	}

	
	
	/** 공지사항 목록 조회 Service
	 * @return list
	 * @throws Exception
	 */
	
	
	public List<Notice> selectList() throws Exception{
		Connection conn = getConnection();
		
		List<Notice> list = dao.selectList(conn);
		
		conn.close();
		
		
		return list;
	}



	/** 공지사항 등록 Service
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Notice notice) throws Exception{
		
		Connection conn = getConnection();
		
		
		int noticeNo = dao.selectNextNo(conn, notice);
		
		int result = 0;
		
		notice.setNoticeNo(noticeNo);
		
		if(noticeNo> 0 ) {
			
			
			
			notice.setNoticeContent(replaceParameter(notice.getNoticeContent()));
			
			
			notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));
			
			
			
			
			
			result = dao.insertNotice(conn,notice);
			
			
			if(result > 0) {
				conn.commit();	
				result = noticeNo;
			}else {
				conn.rollback();
			}
			
			
			
		}
		
		conn.close();
		
		return result;
	}
	

	private String replaceParameter(String param) {
	      String result = param;
	      if(param != null) {
	    	  result = result.replaceAll("&", "&amp;");
	         result = result.replaceAll("<", "&lt;");
	         result = result.replaceAll(">", "&gt;");
	         result = result.replaceAll("\"", "&quot;");
	      }
	      
	      return result;
	   }



	
	
	
	/** 게시글 상세 조회 Service
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	public Notice selectNotice(int noticeNo) throws Exception{
	
		Connection conn = getConnection();
		
		// 1. 공지사항 상세 조회
		Notice notice = dao.selectNotice(conn,noticeNo);
		
		int result = dao.increaseCount(conn,noticeNo);
		
		// 2. 상세 조회 성공 시 조회수 1 증가
		
		if(result > 0) {
			
			conn.commit();
			
			// 반환되는 notice에 저장된 조회수를
			// DB와 맞게 1 증가
			notice.setReadCount(notice.getReadCount() + 1);
			
			
		}
		
		
	
		conn.close();
		
		return notice;
		
	}



	/** 공지사항 수정 화면 service
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	
	
	public Notice updateView(int noticeNo) throws Exception{
		Connection conn = getConnection();
		
		
		Notice notice = dao.selectNotice(conn, noticeNo);
		
		
		// textarea에 개행문자를 정상 적용할 수 있도록
		// <br> 태그를 \r\n으로 변환
		notice.setNoticeContent(notice.getNoticeContent().replace("<br>", "\r\n"));
		
		
		conn.close();
		
		
		return notice;
	}



	public int updateNotice(Notice notice) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
		
		
		notice.setNoticeContent(replaceParameter(notice.getNoticeContent()));
		 
		notice.setNoticeTitle(replaceParameter(notice.getNoticeTitle()));
	
		notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));
		
		notice.setNoticeTitle(notice.getNoticeTitle().replace("\r\n", "<br>"));
		
		
		
		
		
		result = dao.updateNotice(conn,notice);
		
		if(result > 0) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		
		
		conn.close();
		
		
		
		return result;
	}



	public int deleteNotice(int noticeNo) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
	
		
		try {
			
			result = dao.deleteNotice(conn,noticeNo);
			
			
			
			
		}finally {
			
			if(result > 0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			conn.close();
			
		}
		
		
		
		
		
		
		
		return result;
	}
	

	
}










