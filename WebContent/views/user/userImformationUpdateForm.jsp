<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>

#userImforMation .userImforMationBody .userImformationBtn{
	margin-bottom:50px;
}
#userImforMation .userImforMationBody .userImformationTable{
	height: 400px;
}

#userImforMation .userImforMationBody .userImformationTable table tr td
	{
	padding: 0;
	height: 46px;
}

</style>
<div id="userImforMation">
	<div class="userImforMationTitle">
		<div class="container">
			<h1>내정보 수정</h1>
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationTitle --%>

	<div class="userImforMationBody">
		<div class="container">
			<form action="${pageContext.request.contextPath}/shopping" method="post" onsubmit="return userImformationUpdateCheck()">
				<div class="userImformationTable">
					<input type="hidden" name="command" value="userImformationUpdate">
					<table>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="id" readonly="readonly" placeholder="아이디를 입력해주세요" value="${sessionScope.user.id}"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="password" placeholder="비밀번호를 입력해주세요"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" name="passwordCheck" placeholder="비밀번호를 입력해주세요"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" required="required" placeholder="이름을 입력해주세요" value="${sessionScope.user.name}"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="tel" required="required" maxlength="11" placeholder="전화번호를 입력해주세요" value="${sessionScope.user.telephone}"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="address" required="required" id="address" readonly="readonly"> <input type="button" value="우편번호 찾기" onclick="execDaumPostcode()"></td>
						</tr>
						<tr>
							<th>상세주소</th>
							<td><input type="text" name="address" placeholder="상세주소를 입력해주세요">
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="email" name="email" required="required" placeholder="이메일을 입력해주세요" value="${sessionScope.user.email}"></td>
						</tr>

					</table>
				</div>
				<!-- userImformationTable  -->
				<div class="userImformationBtn">
					<input type="submit" value="개인정보 수정"> <input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/shopping?command=home'">
				</div>
				<%-- userImformationBtn --%>
			</form>
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationBody --%>

</div>
<%-- userImforMation --%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	//전화번호 체크
	function telCheck() {
		var tel = $("input[name=tel]").val().trim();
		var flag = false;

		if (!isNaN(tel)) {
			if (tel.length == 11) {
				flag = true;
			} else {
				alert("전화번호 11자리를 입력해주세요");
			}
		} else {
			alert("숫자만 입력해주세요");
		}
		return flag;

	}
	//비밀번호 체크
	function passCheck() {
		var flag = false;
		var pass = $("input[name=password]").val().trim();
		var passCheck = $("input[name=passwordCheck").val().trim();
		if (pass === passCheck)
			flag = true;
		if (flag === false)
			alert("비밀번호가 맞지 않습니다");
		return flag;
	}

	function userImformationUpdateCheck() {
		if (!passCheck())
			return false;
		if (!telCheck())
			return false;
	}
</script>