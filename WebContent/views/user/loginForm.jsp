<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

	<form action="${pageContext.request.contextPath}/shopping" method="post" id="login">
		<input type="hidden" name="command" value="userLogin"> <input
			type="text" name="id" required="required" placeholder="아이디를 입력해주세요">
		<input type="password" name="password" required="required"
			placeholder="비밀번호를 입력해주세요"> <input type="submit" value="로그인">
	</form>
