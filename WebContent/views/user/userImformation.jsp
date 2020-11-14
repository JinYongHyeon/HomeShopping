<%@page import="org.shopping.model.UserVO"%>
<%@page import="sun.security.ec.ECDSAOperations.Seed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<table id="userImformationTable">
		<tr>
			<td>아이디</td>
			<td>${sessionScope.user.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${sessionScope.user.password}</td>
		</tr>

		<tr>
			<td>이름</td>
			<td>${sessionScope.user.name}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${sessionScope.user.telephone}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${sessionScope.user.address}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${sessionScope.user.email}</td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/shopping?command=userImformationUpdateForm">회원정보 수정</a></td>
			<td><input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/shopping?command=home'"></td>
		</tr>
	</table>
	
