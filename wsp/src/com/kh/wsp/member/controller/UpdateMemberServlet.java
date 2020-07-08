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

@WebServlet("/member/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
		// 회원정보 수정에 필요한 파라미터, 세션 값 변수에 저장하기
		
		// 1 ) HttpSession에서 로그인 정보를 얻어옴.
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		// 2 ) 파라미터를 얻어옴
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		String memberPhone = phone1 + "-" + phone2 + "-" + phone3;
		
		String memberEmail = request.getParameter("email");
		
		String post = request.getParameter("post");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		String memberAddress = post + "," + address1 + "," + address2;
		
		String[] interest = request.getParameterValues("memberInterest");
		String memberInterest = null;
		
	
		
		
		if(interest != null) {
			
			memberInterest = String.join(",", interest);
			
		}
		
		
		// 아이디, 전화번호, 이메일, 주소, 관심분야
		Member member = new Member(loginMember.getMemberId(), memberPhone, memberEmail, memberAddress, memberInterest);
		
		int result = 0;
		
		try {
			
			result = new MemberService().updateMember(member);
			String status = null;
			String msg = null;
			String text = null;
			
				
			
			if(result > 0) {
				status = "success";
				msg = "정보 수정 완료";
				text = "즐거운 이용 부탁드립니다.";
						
				loginMember.setMemberPhone(memberPhone);
				loginMember.setMemberEmail(memberEmail);
				loginMember.setMemberAddress(memberAddress);
				loginMember.setMemberInterest(memberInterest);
				
				
				session.setAttribute("loginMember", loginMember);
				
			} else {
				
				status = "error";
				msg = "정보 수정 실패~!";
				text = "나는 바보얌";
				
				
			}
			
			request.getSession().setAttribute("status", status);
			request.getSession().setAttribute("msg", msg);
			request.getSession().setAttribute("text", text);
			
			
			
			
			
		}catch(Exception e) {
			
			

			
			// 리다이렉트 방식은 이전 요청 객체 request 를 폐기하므로
			// 다음 페이지에 메세지를 전달하고 싶을 때 Session을 임시로 사용하는 방법이 있다.
			
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "정보 수정 중 오류 발생");
			
			String path = "/WEB-INF/views/common/errorPage.jsp";
			
			RequestDispatcher view =request.getRequestDispatcher(path);
			view.forward(request, response);
			
			
			
		}
		
		response.sendRedirect("myPage.do");
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
