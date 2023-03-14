package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.Member;

@WebServlet(urlPatterns = { "/index/*" })
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/index/index.jsp");
		/*
		 * request.setAttribute("name", "장성호"); 
		 * request.setAttribute("age", 30);
		 * request.setAttribute("weight", 80);
		 */
		Member member = new Member();
		member.setName("장성호");
		member.setAge(30);
		member.setWeight(80);
		request.setAttribute("member", member); // 뭐든 실을 수 있다.
		dispatcher.forward(request, response);
	}
}
