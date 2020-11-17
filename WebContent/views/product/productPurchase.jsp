<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="${pageContext.request.contextPath}/shopping" method="post">
	<input type="hidden" name="command" value="order">
	<input type="hidden" name="prodcutNo" value="${pvo.productNo}">
	<input type="hidden" name="id" value="${sessionScope.user.id}">
	<div id="buyerInfo">
		<table>
			<tr>
				<th>이름</th>
				<td>${sessionScope.user.name}</td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td>${sessionScope.user.address}</td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td>${sessionScope.user.telephone}</td>
			</tr>
			<tr>
				<th>잔여포인트</th>
				<td>${sessionScope.user.point}</td>
			</tr>
		</table>
	</div>
	<div id="paymentInfo">
		<table>
			<tr>
				<th>제품</th>
				<td><input type="text" name="productName" value="${pvo.productName}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="number" name="productCount" value="${param.productCount}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="productPrice" value="${pvo.productPrice}" readonly="readonly"></td>
			</tr>
		</table>
	</div>
	<div id="paymentBtn">
		<input type="submit" value="결제하기">
	</div>
</form>