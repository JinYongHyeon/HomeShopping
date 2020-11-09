<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>asd</h1>

	<c:choose>
		<c:when test="${sessionScope.user != null}">
		${sessionScope.user.name}님 안녕하세요
	<a href="${pageContext.request.contextPath}/shopping?command=userLogout">로그아웃</a>
			<a href="userImformation.jsp">개인정보</a>
			<c:if test="${sessionScope.user.id=='admin'}">
				<a href="${pageContext.request.contextPath}/shopping?command=userList">관리자 페이지</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/shopping?command=userLoginForm">로그인</a>
			<a href="${pageContext.request.contextPath}/shopping?command=userSingUpForm">회원가입</a>
		</c:otherwise>
	</c:choose>


<%-- 
	이슈 : 로그인 실패 시 로그인 실패 알림 어떻게 하는지??
	      index.jsp 최조 접근 및 index.jsp 접근 시 DB자료를 어떻게 가져오는가??
--%>