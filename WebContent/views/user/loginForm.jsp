<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<div id="login">
	<div class="loginTitle">
		<h1>Dotory Login</h1>
	</div>
	<div class="loginBody">
		<form class="loginForm">
			<div class="login-label-group">
			<input type="text" name="id" id="inputId" required="required" placeholder="아이디를 입력해주세요">
			<label for="inputId">아이디를 입력해주세요.</label>
			</div>
			<div class="login-label-group">
			 <input type="password" id="inputPass" name="password" required="required" placeholder="비밀번호를 입력해주세요">
			 <label for="inputPass">비밀번호를 입력해주세요.</label>
			 </div>
			  <input type="button" value="로그인">
		</form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click",".loginForm input[type=button]",function(){
			var id =$("#inputId").val();
			var pass = $("#inputPass").val();
			if(id === ""){
				alert("아이디를 입력해주세요");
				return;
			}else if(pass === ""){
				alert("비밀번호를 입력해주세요");
				return;
			}
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/shopping",
				dataType:"text",
				data:"command=userLogin&id="+id+"&password="+pass,
				success:function(data){
					if(data==="1"){
						location.href="${pageContext.request.contextPath}/shopping?command=home";
					}else{
						alert("로그인 정보를 잘 못 입력하셨습니다.");
					}
				}
			});
		});
	});
</script>