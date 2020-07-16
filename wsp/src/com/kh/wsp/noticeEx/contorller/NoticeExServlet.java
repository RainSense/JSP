package com.kh.wsp.noticeEx.contorller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.wsp.noticeEx.model.service.NoticeExService;
import com.kh.wsp.noticeEx.model.vo.NoticeEx;

/**
 * Servlet implementation class NoticeExServlet
 */
@WebServlet("/noticeEx/*")
public class NoticeExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		String context = request.getContextPath();
		
		String currentURI = request.getRequestURI();
		
		String excuteChoice = currentURI.substring((context + "/NoticeEx/").length());
	// Front Controller 패턴을 이용하고 있습니다. NoticeEx로 보내는 요청을 한번에 받아 목적되는 uri를 체크하여 실행할 명령을 결정합니다.
		
		String path = null;
		
		
		String msg = null;
		String status = null;
		String text = null;
		
		RequestDispatcher view = null;
		
		String errorMsg = " 과정에서 오류가 발생했습니다.";
		
		
		try {
			
			
			
			
			if (excuteChoice.equals("insertForm.do")) {
				
				errorMsg = "글쓰기 과정에서" + errorMsg;
				
				path = "noticeInsert.jsp";
				
				view = request.getRequestDispatcher(path);
				
				view.forward(request, response);
				
				
				
				
			}
			else if(excuteChoice.equals("list.do") ){
				
				errorMsg = "공지사항 조회 과정에서" + errorMsg;
				
				path = "/WEB-INF/views/notice/noticeList.jsp";
				
				List<NoticeEx> list = new ArrayList<NoticeEx>();
				
				list = new NoticeExService().allListSelect();
				
				
				view = request.getRequestDispatcher(path);
				
				view.forward(request, response);
				
				
			}
			
			
			
			
		}catch(Exception e) {
			
			
		
			
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			
			request.setAttribute("errorMsg", errorMsg);
			
			view = request.getRequestDispatcher(path);
			
			view.forward(request, response);
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		doGet(request, response);
	}

}
