<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
  <script type="text/javascript">
  	alert("아이디/패스워드를 잘 못 입력하셨습니다");
  	location.href="${pageContext.request.contextPath}/shopping?command=userLoginForm";
  </script>