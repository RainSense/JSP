package com.ks.bm.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/SignUpForm.do")
public class SignUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpFormServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String path = "/WEB-INF/views/signUp.jsp";
		
		RequestDispatcher view = request.getRequestDispatcher(path);
		
		view.forward(request, response);
		
		System.out.println("아아");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
