<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fileUploadForm</h1>
<form action="../board/fileUpload" method="POST" 
enctype="multipart/form-data">
	<table>
		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="file"></td>
			</tr>
		</tbody>
	</table>
	<div>
		<button>확인</button>
	</div>
</form>
</body>
</html>