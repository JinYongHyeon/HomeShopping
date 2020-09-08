<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<%if(request.getAttribute("id")==null){ %>
	<script type="text/javascript">
		alert("잘못 접근하셨습니다.");
		location.href="index.jsp";
	</script>
	<%}%>
	<form action="shopping" method="post" onsubmit="return passCheck()">
		<input type="hidden" name="command" value="userFindByPassUpdate">
		<input type="text" name="id" value=<%=request.getAttribute("id")%> readonly="readonly">
		<input type="password" name="password" required="required" placeholder="변경할 비밀번호를 입력해주세요">
		<input type="password" name="passwordCheck" required="required" placeholder="변경할 비밀번호를 재입력해주세요">
		<input type="submit" value="변경">
	</form>
	<script type="text/javascript"
			src="resources/javascript/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>