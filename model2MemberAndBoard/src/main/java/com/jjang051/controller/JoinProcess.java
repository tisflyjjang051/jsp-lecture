package com.jjang051.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class JoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcess() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId("qwer");
		memberDto.setUserPw("1234");
		memberDto.setUserName("강백호");
		memberDto.setUserEmail("kang@hanmail.net");
		memberDto.setUserHp("01011112222");
		memberDto.setZipCode(12345);
		memberDto.setAddress("우리집");
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "http://www.daum.net");
		} else {
			ScriptWriter.alertAndBack(response, "잠시후 다시 시도해 주세요.");
		}
	}
}




