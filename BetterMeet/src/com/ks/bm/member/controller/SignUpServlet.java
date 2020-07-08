package com.ks.bm.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ks.bm.member.model.service.MemberService;
import com.ks.bm.member.model.vo.Member;


@WebServlet("/member/SignUp.do")
public class SignUpServlet extends HttpServlet {
    
	 public SignUpServlet() {
	        super();
	     
	    }
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		
		String memberName = request.getParameter("name");
		String memberEmail = request.getParameter("email");
		String memberPwd = request.getParameter("pass");
		
		Member mem = new Member();
		
		mem.setMemberEmail(memberEmail);
		
		mem.setMemberPwd(memberPwd);
		
		mem.setMemberName(memberName);
		
		
		MemberService service = new MemberService();
		
		int result = 0;
		
		System.out.println("오예");
		
		
		try {
			
			result = service.signUp(mem);
			response.sendRedirect(request.getContextPath());
			System.out.println("오예");
			
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	
		
		
	
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
