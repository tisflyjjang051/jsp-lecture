<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");

	String userPW = request.getParameter("userPW");
	String userName = (String) request.getParameter("userName");
	String gender = (String) request.getParameter("gender");
	String grade = (String) request.getParameter("grade");
	//System.out.println(userID+"==="+userPW);

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TIS001";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO MEMBER  VALUES (?,?,?,?,?)";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	pstmt.setString(3, userName);
	pstmt.setString(4, gender);
	pstmt.setString(5, grade);

	int result = pstmt.executeUpdate();
	System.out.println(result);
	if(result > 0) {
		out.println("<script>alert('회원가입이 되었습니다.');</script>");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>