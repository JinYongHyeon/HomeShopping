<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<form action="shopping" method="post" onsubmit="return singUpCheck()">
		<input type="hidden" name="command" value="usersingUp">
		<table id="singUpTable">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required"
					placeholder="아이디를 입력해주세요"></td>
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
					placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" required="required"
					maxlength="11" placeholder="전화번호를 입력해주세요"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required"
					placeholder="주소를 입력해주세요"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" required="required"
					placeholder="이메일을 입력해주세요"></td>
			</tr>
			<tr>
				<td><input type="submit" value="회원가입"></td>
				<td><input type="button" value="취소" onclick="back()"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript"
		src="resources/javascript/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>