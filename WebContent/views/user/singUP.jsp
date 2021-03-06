<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
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

#userImforMation{
	height: 600px;
}

#userImforMation .userImforMationBody .userImformationTable table tr:nth-child(1) td input{
	width:60%;
}
#userImforMation .userImforMationBody .userImformationTable table tr:nth-child(1) td span{
	width:30%;
	font-size:10px;
	font-weight:bold;
	margin-left:5px;
}

</style>
<div id="userImforMation">
	<div class="userImforMationTitle">
		<div class="container">
			<h1>회원가입</h1>
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationTitle --%>
	
	<div class="userImforMationBody">
		<div class="container">
			<div class="userImformationTable">
	<form action="shopping" method="post" onsubmit="return singUpCheck()">
		<div class="userImformationTable">
		<input type="hidden" name="command" value="usersingUp">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="singId" name="id" required="required" placeholder="아이디를 입력해주세요"><span id="idCheck"></span></td>

			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" required="required" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="passwordCheck" required="required" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required="required" placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="tel" required="required" maxlength="11" placeholder="전화번호를 입력해주세요"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" required="required" id="address" readonly="readonly"> <input type="button" value="우편번호 찾기" onclick="execDaumPostcode()"></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="address" required="required" placeholder="상세주소를 입력해주세요">
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" required="required" placeholder="이메일을 입력해주세요"></td>
			</tr>
		</table>
		</div>
		<div class="userImformationBtn">
			<input type="submit" value="회원가입">
			<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/shopping?command=home'">
		</div>
		<%-- userImformationBtn --%>
	</form>
				</div>
			<!-- userImformationTable  -->
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationBody --%>
</div>
<%-- userImforMation --%>
<script	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
var idCheck ="";
	$(document).ready(function(){
		var xhr;
		$("#singId").keyup(function(){
			if($(this).val().length < 8){
				idCheck="";
				$("#idCheck").html("아이디 8자 이상 작성 부탁드립니다.").css("color","red");
				return; 
			}else{
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					if(xhr.responseText == 0){
						$("#idCheck").html("사용가능한 아이디 입니다.").css("color","blue");
						idCheck = xhr.responseText;
					}else{
						$("#idCheck").html("이미존재하는 아이디 입니다.").css("color","red");
						idCheck = xhr.responseText;
					}
				}
			}
			xhr.open("post","${pageContext.request.contextPath}/shopping");
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.send("command=userIdCheck&id="+$(this).val());
			}
			});
		
	});
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
	
	//통합체크 회원가입
	function singUpCheck() {
		if(idCheck == ""){
			alert("아이디 10자 이상 작성해 주십시오.");
			return false;
		}else if(idCheck != 0){
			alert("아이디 중복체크 다시 해주십시오.");
			return false;
		}
		if(!passCheck())return false;
		if(!telCheck())return false;
	}
</script> 