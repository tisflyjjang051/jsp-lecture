package com.jjang051.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriter;

@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = memberDao.getLoggedMember(userId, userPw);
		HttpSession session = request.getSession();
		if(loggedMember!=null) {
			session.setAttribute("loggedId", loggedMember.getUserId());
			session.setAttribute("loggedName", loggedMember.getUserName());
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriter.alertAndNext(response,loggedMember.getUserName()+"님 반갑습니다.", "../index/");
		}
	}
}









