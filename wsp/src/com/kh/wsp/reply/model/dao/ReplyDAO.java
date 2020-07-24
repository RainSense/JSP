package com.kh.wsp.reply.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.wsp.reply.model.vo.Reply;

public class ReplyDAO {
	
	private Properties prop;
	
	public ReplyDAO() throws Exception{
		
		String fileName = 
				ReplyDAO.class.getResource("/com/kh/wsp/sql/reply/reply-query.properties").getPath();
		
		prop = new Properties();
		prop.load(new FileReader(fileName));
		
	}

	
	public List<Reply> selectList(Connection conn, int boardNo) throws Exception{
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Reply> rList = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			
			pstmt.setInt(1, boardNo);
			
			
			
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Reply>();
			
			
			
			
			Reply reply = null;
			
			while(rset.next()) {
				
				
				reply = new Reply(rset.getInt("REPLY_NO"), rset.getString("REPLY_CONTENT"),rset.getString("MEMBER_ID"), rset.getTimestamp("REPLY_CREATE_DT"),rset.getTimestamp("REPLY_MODIFY_DT"));
		
				
				rList.add(reply);
			}
			
			
			
		}finally {
			
			rset.close();
			pstmt.close();
			
		}
		
		
		
		
		
		return rList;
	}


	public int insertReply(Connection conn, Reply reply) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		
		try {
			
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, reply.getReplyContent());
			
			pstmt.setInt(2,reply.getParentBoardNo());
			
			pstmt.setString(3, reply.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}finally {
			pstmt.close();
		}
		
		
		
		
		
		
		
		
		return result;
	}


	public int deleteReply(Reply reply, Connection conn) throws Exception{
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteReply");
		
		
		try {
			
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, reply.getBoardType());
			pstmt.setInt(2,reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
			
			
			
			
			
		}finally {
			
			pstmt.close();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}
	
	
	
}
