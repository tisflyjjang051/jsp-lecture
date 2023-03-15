package com.jjang051.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ClockDao;
import com.jjang051.model.ClockDto;
import com.jjang051.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet("/board/fileUpload02")
public class FileUploadController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadController2() {
        super();
    }

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int maxFileSize = 1024*1024*50; // 50메가
		String encoding = "UTF-8";
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		String savePath = "upload";// 저장할 폴더 이름
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
//		String realPath = "C:\\upload";
		
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		/*MultipartRequest mutipartRequest = 
				new MultipartRequest(request, 파일이 저장되는 경로, 올릴 수 있는 파일 사이즈, 
						인코딩, 중복파일 이름 처리);*/
		MultipartRequest mutipartRequest = 
				new MultipartRequest(request, realPath, maxFileSize, 
				encoding, fileRenamePolicy);
		
		
		String title = mutipartRequest.getParameter("title");
		String category = mutipartRequest.getParameter("category");
		int depth = Integer.parseInt( mutipartRequest.getParameter("depth"));
		int price = Integer.parseInt( mutipartRequest.getParameter("price"));
//		String originalFile = mutipartRequest.getOriginalFileName("file");
//		String renameFile = mutipartRequest.getFilesystemName("file");
		
		Enumeration files = mutipartRequest.getFileNames();
		while (files.hasMoreElements()) {
			String file = (String) files.nextElement();
			String file_name = mutipartRequest.getFilesystemName(file);
			// 중복된 파일을 업로드할 경우 파일명이 바뀐다.
			String originalFile = mutipartRequest.getOriginalFileName(file);
			String renameFile = mutipartRequest.getFilesystemName(file);
			System.out.print("업로드된 파일명 : " + renameFile);
			System.out.print("원본 파일명 : " + originalFile);
			ClockDto clockDto = new ClockDto();
			clockDto.setTitle(title);
			clockDto.setCategory(category);
			clockDto.setDepth(depth);
			clockDto.setPrice(price);
			clockDto.setClockImg(originalFile);
			clockDto.setClockRealImg(renameFile);
			ClockDao clockDao = new ClockDao();
			int result = clockDao.insertClock(clockDto);
		}
		
		
		// db에 받은 값 입력하기....
		
	}

}
