<%@page import="org.shopping.model.UserVO"%>
<%@page import="sun.security.ec.ECDSAOperations.Seed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보</title>

</head>
<body>
	<%
		HttpSession session = request.getSession(false);
	UserVO user = null;
	if (session != null && session.getAttribute("user") != null) {
		user = (UserVO) session.getAttribute("user");
	%>
	<table id="userImformationTable">
		<tr>
			<td>아이디</td>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=user.getPassword()%></td>
		</tr>

		<tr>
			<td>이름</td>
			<td>
			<td><%=user.getName()%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
			<td><%=user.getTel()%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
			<td><%=user.getAddress()%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
			<td><%=user.getEmail()%></td>
		</tr>
		<tr>
			<td><a href="userImformationUpdateForm.jsp">회원정보 수정</a></td>
			<td><input type="button" value="취소" onclick="back()"></td>
		</tr>
	</table>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("로그인을 해주시길 바랍니다.");
		location.href = "index.jsp";
	</script>
	<%
		}
	%>
	<script type="text/javascript"
		src="resources/javascript/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>