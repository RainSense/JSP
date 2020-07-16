package com.kh.wsp.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.wsp.member.model.vo.Member;
import com.kh.wsp.notice.model.service.NoticeService;
import com.kh.wsp.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// Front Controller 패턴
		// - 클라이언트의 요청을 한 곳으로 집중 시켜 개발하여
		//   코드 길이 감소와 유지보수성을 증가시킨 패턴
		
		// - 요청에 따른 Servlet을 각각 생성하지 않고
		//   하나의 Servlet에서 여러 요청을 처리함.
		
		
		String uri = request.getRequestURI();
		// http://localhost:8080/wsp/notice/list.do
		
		
		String contextPath = request.getContextPath();
		// http://localhost:8080/wsp
		
		String command = uri.substring((contextPath+"/notice").length());
		
		
		
		// forward용 변수
		String path = null;
		
		RequestDispatcher view = null;
		
		// 메세지 전달용 변수
		String status = null;
		String msg = null;
		String text = null;
		String errorMsg = " 과정에서 오류가 발생했습니다.";
		
		
		try {
			
			NoticeService service = new NoticeService();
			
			
			// ===== 공지사항 목록 조회 Controller =====
			if(command.equals("/list.do")) {
				errorMsg = "공지사항 목록 조회" + errorMsg;
				
				List<Notice> list = service.selectList();
				
				path = "/WEB-INF/views/notice/noticeList.jsp";
				request.setAttribute("list", list);
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			
			
			//	======= 공지사항 등록 화면 이동 Controller ======
			else if(command.equals("/insertForm.do")) {
				
				path = "/WEB-INF/views/notice/noticeInsert.jsp";
				
				view = request.getRequestDispatcher(path);
				
				view.forward(request, response);
				
			}
			
			else if(command.equals("/view.do")) {
				errorMsg = "공지사항 상세 조회" + errorMsg;
				
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				
				Notice notice = service.selectNotice(noticeNo);
				
				if(notice != null) {	// 조회 결과가 있을 경우
					path = "/WEB-INF/views/notice/noticeView.jsp";
					request.setAttribute("notice", notice);
				
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				
				}else { // 조회결과가 없을 경우 
					
					request.getSession().setAttribute("status", "error");
					request.getSession().setAttribute("msg", "뭐하는거야 이자슥아!");
					response.sendRedirect("list.do");
				}
				
				
				
				
				
			}
			
			
			
			
			// =====공지사항 등록 컨트롤러 =====
			else if (command.equals("/insert.do")) {
				HttpSession session = request.getSession();
				
				String noticeTitle = request.getParameter("title");
				String noticeContent = request.getParameter("content");
				String memberId = ((Member)session.getAttribute("loginMember")).getMemberId();				
				
				Notice notice = new Notice(noticeTitle, noticeContent, memberId);
				
				int result = service.insertNotice(notice);
				
				
				if(result > 0) {
					status = "success";
					msg = "공지사항이 등록되었습니다.";
					path = "list.do?no=" + result;
					// 추후 작성한 글로 바로 이동하도록 수정 예정
				}else	{
					status = "error";
					msg = "공지사항 등록 실패";
					path = "list.do";					
				}
				
				
				session.setAttribute("status", status);
				session.setAttribute("msg", msg);
				response.sendRedirect(path);
				
				
				
				
			}
			
			
			
			//	=====	공지사항 수정 화면 Controller =====
			else if(command.equals("/updateForm.do")) {
				
				errorMsg = "공지사항 수정 화면으로 전환하는" + errorMsg;
				
				
				// 쿼리스트링으로 전달받은 글번호 저장
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				
				// DB에서 해당 글을 조회하여 얻어오기
				Notice notice = service.updateView(noticeNo);
				
				
				if(notice != null) {
					
					path = "/WEB-INF/views/notice/noticeUpdate.jsp";
					
					request.setAttribute("notice", notice);
					
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				}else {
					request.getSession().setAttribute("status", "error");
					request.getSession().setAttribute("msg", "공지사항이..조회가..안돼요.");
					
					//  이전 요청 주소를 재요청
					//response.sendRedirect(request.getHeader("referer"));
					
					response.sendRedirect("view.do?no=" + noticeNo);
					
				}
				
				
				
				
				
				
			}
			
			
			else if (command.equals("/update.do")) {
				
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				
				String noticeTitle = request.getParameter("title");
				
			
				
				String noticeContent = request.getParameter("content");
				
				
				Notice notice = new Notice(noticeTitle, noticeContent);
				
				notice.setNoticeNo(noticeNo);
				
				int result = 0;
				
				result = service.updateNotice(notice);
				path = "view.do?no=" + noticeNo;
				
				if(result > 0) {
					
					
					
					status = "success";
					msg = "공지사항 수정 성공";
					
					
					
					
				}else {
					
					status = "error";
					msg = "공지사항 수정 실패";
					//  이전 요청 주소를 재요청
					//response.sendRedirect(request.getHeader("referer"));
					
					
				}
				
				request.getSession().setAttribute("status", status);
				request.getSession().setAttribute("msg", msg);
				
				
				response.sendRedirect(path);
				
				
				
			}
			else if (command.equals("/delete.do")) {
				
				
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				
				
				
				int result = service.deleteNotice(noticeNo);

				
				path = "list.do";
				
				
				if(result > 0) {
					
					status = "success";
					msg = "공지사항 삭제에 성공하였습니다.";
					
				}else {
					
					status = "error";
					msg = "공지사항 삭제에 오류가 발생하였습니다.";
					
				}
				
				
				request.getSession().setAttribute("status",status );
				request.getSession().setAttribute("msg",msg );
				
				
				response.sendRedirect(path);
				
				
				
				
				
				
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
