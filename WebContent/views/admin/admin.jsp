<%@page import="org.shopping.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<span><a href="${pageContext.request.contextPath}/shopping?command=userList">유저 정보</a></span>
	<span><a href="${pageContext.request.contextPath}/shopping?command=productList">상품 정보</a></span>
	<div class="container">


		<%--유저정보 시작 --%>
		<form action="shopping" method="get">
			<input type="hidden" name="command" value="userFindByList"> <input
				type="text" name="id" required="required"
				placeholder="검색 할 아이디를 입력해주세요"> <input type="submit"
				value="검색">
		</form>
		<table id="adminTable">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>마일리지</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${requestScope.list != null}">
						<c:forEach items="${requestScope.list}" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.password}</td>
								<td>${user.name}</td>
								<td>${user.telephone}</td>
								<td>${user.address}</td>
								<td>${user.email}</td>
								<td>${user.totalPurchase}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">회원정보가 존재하지 않습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<%-- 유저정보 끝 --%>
		<%-- 상품정보 시작 --%>
		
		<form action="shopping" method="get">
			<input type="hidden" name="command" value="ProductFindByList">
			<input type="text" name="name" required="required"
				placeholder="검색 할 상품명 입력해주세요"> <input type="submit"
				value="검색">
		</form>
		<form action="shopping" method="post"
			onsubmit="return productCheckbox()">
			<input type="hidden" name="command" value="productDelete">
			<table id="adminTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>상품가격</th>
						<th>메인사진</th>
						<th>재고</th>
						<th>상품판매량</th>
						<th>등록일</th>
						<th>비고</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${requestScope.productList != null }">
							<c:forEach items="${requestScope.productList}" var="product">
								<tr>
									<td>${product.productNo}</td>
									<td>${product.productName}</td>
									<td>${product.productPrice}</td>
									<td>${product.productMainImg}</td>
									<td>${product.productPossesionCount}</td>
									<td>${product.productTotalSale}</td>
									<td>${product.productDate}</td>
									<td><input type="checkbox" name="productCk"	value="${product.productNo}"></td>
									<td><a href="${pageContext.request.contextPath}/shopping?command=productUpdateForm&no=${product.productNo}">수정</a></td>
								</tr>
							</c:forEach>

						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="9">상품이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>

			</table>
			<input type="button" value="상품추가"
				onclick="location.href='productInsert.jsp'"> <input
				type="submit" value="상품삭제">
		</form>
		<%-- 상품정보 끝 --%>
	</div>
	