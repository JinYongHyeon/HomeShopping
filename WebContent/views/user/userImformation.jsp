<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="userImforMation">
	<div class="userImforMationTitle">
		<div class="container">
			<h1>내정보</h1>
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationTitle --%>
	<div class="userImforMationBody">
		<div class="container">
			<div class="userImformationTable">
				<table>
					<tr>
						<th>아이디</th>
						<td>${sessionScope.user.id}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${sessionScope.user.name}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${sessionScope.user.telephone}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${sessionScope.user.address}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${sessionScope.user.email}</td>
					</tr>
					<tr>
						<th>마일리지</th>
						<td>${sessionScope.user.point}</td>
					</tr>
				</table>
			</div>
			<!-- userImformationTable  -->
			<div class="userImformationBtn">
				<input type="button" value="회원정보 수정" onclick="location.href='${pageContext.request.contextPath}/shopping?command=userImformationUpdateForm'"> <input type="button" value="구매내역" onclick="location.href='${pageContext.request.contextPath}/shopping?command=home'">
			</div>
		</div>
		<%-- container --%>
	</div>
	<%-- userImforMationBody --%>
</div>
<%-- userImforMation --%>


