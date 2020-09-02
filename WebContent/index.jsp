<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/style/css.css">
<title>홈쇼핑</title>
</head>
<body>
	<%
		HttpSession session = request.getSession(false);
	if (session != null && session.getAttribute("user") != null) {
		UserVO vo = (UserVO) session.getAttribute("user");
	%>
	<%=vo.getName()%>님 안녕하세요
	<a href="shopping?command=userLogout">로그아웃</a>
	<%
		if (vo.getId().equals("admin")) {
	%>
	<a href="admin.jsp">관리자 페이지</a>
	<%
		}
	%>
	<%
		} else {
	%>

	<form action="shopping" method="post" id="login">
		<input type="hidden" name="command" value="userLogin"> <input
			type="text" name="id" required="required" placeholder="아이디를 입력해주세요">
		<input type="password" name="password" required="required"
			placeholder="비밀번호를 입력해주세요"> <input type="submit" value="로그인">
	</form>
	<a href="singUP.jsp">회원가입</a>
	<a href="">아이디 찾기</a>
	<a href="">비밀번호 찾기</a>
	<%
		}
	%>
	<script type="text/javascript"
		src="resources/javascript/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>