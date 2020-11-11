<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    	<table>
			<tr>
				<td>상품명</td>
				<td>${requestScope.product.productName}</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>${requestScope.product.productPrice}</td>
			</tr>
			<tr>
				<td>상품재고</td>
				<td>${requestScope.product.productPossesionCount}</td>
			</tr>
			<tr>
				<td>상품종류</td>
			<td>${requestScope.product.kinds}</td>
			</tr>
			<tr>
				<td>상품내용</td>
				<td><pre>${requestScope.product.productContent}</pre></td>
			</tr>
		</table>