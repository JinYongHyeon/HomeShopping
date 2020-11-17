<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<thead>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품이미지</th>
			<th>가격</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${requestScope.cartList == null}">
			<tr>
				<td colspan="5">담은 장바구니가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${requestScope.cartList}" var="cart">
		<tr>
			<td>${cart.productVO.productNo}</td>
			<td>${cart.productVO.productName}</td>
			<td>${cart.productVO.productMainImg}</td>
			<td>${cart.productVO.productPrice}</td>
			<td>${cart.productVO.productNo}</td>
			<td>
				<form action="${pageContext.request.contextPath}/shopping" method="post">
					<input type="hidden" name="command" value="productDeleteCart">
					<input type="hidden" name="id" value="${cart.userVO.id}">
					<input type="hidden" name="productNo" value="${cart.productVO.productNo}">
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
		 </c:forEach>
		</c:otherwise>
	</c:choose>
	
	</tbody>
</table>


	
	
	
	
