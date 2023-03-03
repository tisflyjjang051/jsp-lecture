<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "나는 pageContext입니다.");  //단일 페이지 에서만 유지
		request.setAttribute("name", "나는 request입니다.");  // forward로 넘기면 유지
		session.setAttribute("name","나는 session입니다.");   // session이 끊이지 않으면 유지
		application.setAttribute("name","나는 application입니다.");  // 서버 종료시까지 유지
		
		out.println("====scope first====<br>");
		out.println("pageContext==="+pageContext.getAttribute("name")+"<br>");
		out.println("request==="+request.getAttribute("name")+"<br>");
		out.println("session==="+session.getAttribute("name")+"<br>");
		out.println("application==="+application.getAttribute("name")+"<br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("second.jsp");
		dispatcher.forward(request, response);
		
	%>
</body>
</html>