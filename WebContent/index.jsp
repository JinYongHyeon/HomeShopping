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
	<a href="userImformation.jsp">개인정보</a>
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

	<a href="loginForm.jsp">로그인</a>
	<a href="singUP.jsp">회원가입</a>

	<%
		}
	%>
		<script type="text/javascript"
			src="resources/javascript/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>
<%-- 
	이슈 : 로그인 실패 시 로그인 실패 알림 어떻게 하는지??
	      index.jsp 최조 접근 및 index.jsp 접근 시 DB자료를 어떻게 가져오는가??
--%>