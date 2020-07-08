package com.ks.bm.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.ks.bm.member.model.service.MemberService;
import com.ks.bm.member.model.vo.Member;


@WebServlet("/member/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		
		String memberName = request.getParameter("your_name");
		
		String memberPwd = request.getParameter("your_pass");
		
		Member mem = new Member();
		
		mem.setMemberName(memberName);
		mem.setMemberPwd(memberPwd);	
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(10);
		
		try {
			
			System.out.println("코코루루");
			Member loginMember = new MemberService().checkId(mem);
			
			System.out.println("코코링");
			
			if(loginMember!=null) {
				
				
			
			
			session.setAttribute("memberName", mem.getMemberName());
			
			session.setAttribute("memberEmail", mem.getMemberEmail());
			
			session.setAttribute("memberGrade", mem.getMemberGrade());
			
			
			System.out.println("쀼쇼쀼쇼");
				
			}
			
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath());
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
