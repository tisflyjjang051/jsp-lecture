<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="join_process.jsp">
		<div>
			<label><span>아이디</span><input type="text" name="userID"></label>
		</div>
		<div>
			<label><span>패스워드</span><input type="password" name="userPW"></label>
		</div>
		<div>
			이름 추가하기....   userName, gender, grade
		</div>
		<div>
			성별 추가하기.... radio 처리하기
		</div>
		<div>
			학력 추가하기.... select 처리하기  (초졸(초졸), 중졸(중졸), 대졸(대졸), 대학원졸(대학원졸))
		</div>
		<div>
			<button>회원가입</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>