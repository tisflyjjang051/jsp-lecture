<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<form action="loginProcess" method="POST">
	<table>
		<colgroup>
			<col style="width: 20%" />
			<col style="width: 80%" />
		</colgroup>
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" id="userId"
					placeholder="아이디를 입력하세요." />
					<button class="btn idCheck">아이디 중복확인</button></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="userPw" id="userPw"
					placeholder="패스워드를 입력하세요." /></td>
			</tr>
			
		</tbody>
	</table>
	<div>
		<button class="btn confirm">회원가입</button>
		<button type="reset">취소</button>
	</div>
</form>
<script>
	//jQuery alias  $
	$(".confirm").on("click", function() {
		if ($("#userID").val() === "") {
			alert("아이디를 입력해주세요.");
			$("#userID").focus();
			return false;
		}
		if ($("#userPW").val() === "") {
			alert("패스워드를 입력해주세요.");
			$("#userPW").focus();
			return false;
		}
	});
</script>
<%@ include file="../include/footer.jsp"%>
