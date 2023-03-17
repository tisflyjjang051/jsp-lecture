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

@WebServlet("/board/writeProcess")
public class BoardWriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardWriteProcessController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//write에서 넘어오는 데이터 받아서 dao넘겨주고 페이지 바꿔주기
		request.setCharacterEncoding("UTF-8");
		BoardDto boardDto = new BoardDto();
		boardDto.setUserName(request.getParameter("userName"));
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setContents(request.getParameter("contents"));
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.insertBoard(boardDto);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "작성이 완료 되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "다시 시도해주세요.");
		}
		
		
	}

}
