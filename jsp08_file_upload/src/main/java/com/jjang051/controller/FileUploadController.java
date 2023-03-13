package com.jjang051.controller;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fileupload")
public class FileUploadController extends HttpServlet {
	public FileUploadController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String file = request.getParameter("file");
		System.out.println(file);
	}
}
