package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		int total = boardDao.getTotal();
		int listPerPage = 7;
		int pageTotal = (int)(Math.ceil(total / listPerPage));
		
		String tempClickedPage = request.getParameter("page");
		int clickedPage = 0;
		
		if(tempClickedPage==null) {
			clickedPage = 1;
		} else {
			clickedPage = Integer.parseInt(tempClickedPage); 
		}
//		1,5
//		6,10,
//		11,15
//		16,20
		
		int start = clickedPage*listPerPage; 
		int end = start+listPerPage-1;
		
		ArrayList<BoardDto> boardList = 
				(ArrayList<BoardDto>) boardDao.getAllBoard02(start,end);
		request.setAttribute("boardList", boardList);
		request.setAttribute("total", total);
		request.setAttribute("listPerPage", listPerPage);
		//request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("pageStart", 1);
		request.setAttribute("pageEnd", pageTotal);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}
}







