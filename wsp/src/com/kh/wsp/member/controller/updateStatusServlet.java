package com.kh.wsp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.wsp.member.model.service.MemberService;
import com.kh.wsp.member.model.vo.Member;


@WebServlet("/member/updateStatus.do")
public class updateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateStatusServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		HttpSession session = request.getSession();
		
		Member member = (Member)session.getAttribute("loginMember");
		
		
		String memberPwd = request.getParameter("currentPwd");
		String memberId = member.getMemberId();
		
		int result = 0;
		MemberService service = new MemberService();
		
		
		member = new Member(memberId, memberPwd);
		
		String status = null;
		String msg = null;
		String text = null;
		
		Boolean flag = true;
		
		try {
		
			result = service.seccessionMember(member);
			
			
			if(result > 0) {
				status = "success";
				msg = "회원 탈퇴 성공!";
				text = "다신 오지마! 나도 니가 싫어!!";
				
				flag=false;
				session.removeAttribute("loginMember");
				
				response.sendRedirect(request.getContextPath());
				
				
				
			}else if (result ==0){
				status = "error";
				msg = "회원 가입 실패!";
				text = "회원 탈퇴 중 문제가 발생했어요.";
				
				
			}else {
				
				status = "error";
				msg = "비밀번호 오류!";
				text = "비밀번호가 정확하지 않습니다.";
				
				
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			String path = "/WEB-INF/views/common/errorPage.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(path);
			
			view.forward(request, response);
			
			
		}
		
		if(flag)
			response.sendRedirect("secession.do");
		
		session.setAttribute("msg", msg);
		session.setAttribute("status", status);
		session.setAttribute("text", text);
		
	
		
		
		
		
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
