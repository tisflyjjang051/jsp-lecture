package com.bunny.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bunny.model.BoardDao;
import com.bunny.model.BoardDto;
import com.bunny.utils.ScriptWriter;

@WebServlet("/board/modifyProcess")
public class BoardModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModifyProcessController() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDto boardDto = new BoardDto();
		BoardDao boardDao = new BoardDao();
		
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setUserName(request.getParameter("userName"));
		boardDto.setContents(request.getParameter("contents"));
		boardDto.setNo(Integer.parseInt(request.getParameter("no")));
		
		System.out.println(boardDto.toString());
		
		int result = boardDao.updateBoard(boardDto);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 수정 되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "다시 시도해주세요.");
		}
	}

}
