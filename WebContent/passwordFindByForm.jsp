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
		if (request.getAttribute("flag") != null) {
		boolean flag = (boolean) request.getAttribute("flag");
		if (!flag) {
	%>
			<script type="text/javascript">
				alert("계정이 존재하지 않습니다.");
				var form = document.userPassFindForm;
				form.reset();
			</script>
	<%
		}
	}
	%>


	<form action="shopping" method="post" name="userPassFindForm">
		<input type="hidden" name="command" value="userFindByPass"> <input
			type="text" name="id" required="required" placeholder="아이디를 입력해주세요">
		<input type="text" name="name" required="required"
			placeholder="이름을 입력하세요"> <input type="email" name=email
			required="required" placeholder="이메일을 입력하세요"> <input
			type="submit" value="아아디 찾기">
	</form>

	<a href="index.jsp">메인페이지</a>
		<script type="text/javascript"
			src="resources/javascript/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>