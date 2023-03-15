<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<main>
	<form class="form" action="../board/writeProcess" method="POST">
		<table class="board">
			<colgroup>
				<col style="width:20%">
				<col style="width:80%">
			</colgroup>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="contents" id="summernote"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btns">
			<button class="btn confirm">확인</button>
			<button class="btn reset" type="reset">취소</button>
		</div>
	</form>
</main>
<script>
	$("#summernote").summernote({
		height:300
	})
</script>
<%@ include file="../include/footer.jsp" %>
