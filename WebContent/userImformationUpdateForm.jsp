<%@page import="org.shopping.model.UserVO"%>
<%@page import="sun.security.ec.ECDSAOperations.Seed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>



</head>
<body>
	<%
		HttpSession session = request.getSession(false);
	UserVO user = null;
	if (session != null && session.getAttribute("user") != null) {
		user = (UserVO) session.getAttribute("user");
	%>
	<form action="shopping" method="post" onsubmit="return singUpCheck()">
		<input type="hidden" name="command" value="userImformationUpdate">
		<table id="userImformationTable">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" readonly="readonly"
					placeholder="아이디를 입력해주세요" value="<%=user.getId()%>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required="required"
					placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passwordCheck"
					required="required" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required"
					placeholder="이름을 입력해주세요" value="<%=user.getName()%>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" required="required"
					maxlength="11" placeholder="전화번호를 입력해주세요"
					value="<%=user.getTel().replaceAll("-", "")%>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required"
					placeholder="주소를 입력해주세요" value="<%=user.getAddress()%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" required="required"
					placeholder="이메일을 입력해주세요" value="<%=user.getEmail()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="개인정보 수정"></td>
				<td><input type="button" value="취소" onclick="back()"></td>
			</tr>
		</table>
	</form>
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