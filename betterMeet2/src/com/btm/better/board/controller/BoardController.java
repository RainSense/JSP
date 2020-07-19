package com.btm.better.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btm.better.board.model.service.FreeBoardService;
import com.btm.better.board.model.vo.FreeBoard;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String path = request.getRequestURL().substring(40);
		
		
		
		
		System.out.println(path);
		System.out.println(request.getContextPath().length());
		
		if(path.equals("boardView.do")) {
		List<FreeBoard> fboardList = new ArrayList();
		
		try {
			
			fboardList = new FreeBoardService().selectAllFboard();
			
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			
			
		}
		
		
		request.setAttribute("fBoardList", fboardList);
		
		
		
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/board/freeBoard.jsp");
		
		view.forward(request, response);
		}
		
		
		
		
		else if (path.equals("fBoardWrite.do")) {
			
			
			path = "/WEB-INF/views/board/freeBoardWrite.jsp";
			
			
			RequestDispatcher view = request.getRequestDispatcher(path);
			
			
			view.forward(request, response);
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		doGet(request, response);
	}

}
