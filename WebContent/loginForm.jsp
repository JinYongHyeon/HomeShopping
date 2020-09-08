<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%
	if (request.getAttribute("fail") != null) {
	String errorMessage = (String)request.getAttribute("fail");
%>
<script type="text/javascript">
	alert("<%=errorMessage%>");
</script>
<%
	}
%>
<link rel="stylesheet" type="text/css" href="resources/style/css.css">
</head>
<body>
	<form action="shopping" method="post" id="login">
		<input type="hidden" name="command" value="userLogin"> <input
			type="text" name="id" required="required" placeholder="아이디를 입력해주세요">
		<input type="password" name="password" required="required"
			placeholder="비밀번호를 입력해주세요"> <input type="submit" value="로그인">
	</form>
	
	<a href="idFindByForm.jsp">아이디 찾기</a>
	<a href="passwordFindByForm.jsp">비밀번호 찾기</a>
</body>
</html>