<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<%
		if (request.getAttribute("id") == null) {
		if (request.getParameter("fail") != null) {
	%>
	<script type="text/javascript">
		alert("아이디 찾기 실패 ");
	</script>
	<%
		}
	%>
	<form action="shopping" method="post">
		<input type="hidden" name="command" value="userFindById">
 		<input type="text" name="name" required="required"
			placeholder="이름을 입력하세요"> <input type="email" name=email
			required="required" placeholder="이메일을 입력하세요"> <input
			type="submit" value="아아디 찾기">
	</form>
	<%
		} else {
	String id = (String) request.getAttribute("id");
	%>
	<h1>아이디 : <%=id%></h1>

	<%
		}
	%>
	<a href="index.jsp">메인페이지</a>
</body>
</html>