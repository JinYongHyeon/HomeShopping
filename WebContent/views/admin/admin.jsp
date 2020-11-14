<%@page import="org.shopping.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<span><a
	href="${pageContext.request.contextPath}/shopping?command=userList">유저
		정보</a></span>
<span><a
	href="${pageContext.request.contextPath}/shopping?command=productList">상품
		정보</a></span>
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
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${requestScope.paging.previousPageGroup}">
				<li class="page-item"><c:choose>
						<c:when test="${requestScope.id != null}">
							<a class="page-link"
								href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${paging.startGroup-1}&id=${requestScope.id}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link"
								href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${paging.startGroup-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
			<c:forEach begin="${requestScope.paging.startGroup}"
				end="${requestScope.paging.endGroup}" var="num">
				<c:choose>
					<c:when test="${requestScope.paging.nowPage==num}">
						<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${requestScope.id != null}">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${num}&id=${requestScope.id}">${num}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${num}">${num}</a></li>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.paging.nextPageGroup}">

				<li class="page-item"><c:choose>
						<c:when test="${requestScope.id != null}">
							<a class="page-link"
								href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${paging.endGroup+1}&id=${requestScope.id}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link"
								href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${paging.endGroup+1}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
		</ul>
	</nav>
	<%-- 유저정보 끝 --%>
	<%-- 상품정보 시작 --%>

	<form action="shopping" method="get">
		<input type="hidden" name="command" value="productFindByList">
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
					<th>종류</th>
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
								<td>${product.kinds}</td>
								<td><a href="${pageContext.request.contextPath}/shopping?command=productDetail&productNo=${product.productNo}">${product.productName}</a></td>
								<td>${product.productPrice}</td>
								<td><img src="${pageContext.request.contextPath}/resources/img/product/main/${product.productMainImg}"></td>
								<td>${product.productPossesionCount}</td>
								<td>${product.productTotalSale}</td>
								<td>${product.productDate}</td>
								<td><input type="checkbox" name="productCk"
									value="${product.productNo}"></td>
								<td><a
									href="${pageContext.request.contextPath}/shopping?command=productUpdateForm&no=${product.productNo}">수정</a></td>
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

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${requestScope.paging.previousPageGroup}">
					<li class="page-item"><c:choose>
							<c:when test="${requestScope.productName != null}">
								<a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=productFindByList&nowPage=${paging.startGroup-1}&name=${requestScope.productName}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a>
							</c:when>
							<c:otherwise>
								<a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=productList&nowPage=${paging.startGroup-1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a>
							</c:otherwise>
						</c:choose></li>

				</c:if>
				<c:forEach begin="${requestScope.paging.startGroup}"
					end="${requestScope.paging.endGroup}" var="num">
					<c:choose>
						<c:when test="${requestScope.paging.nowPage==num}">
							<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${requestScope.productName != null}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/shopping?command=productFindByList&nowPage=${num}&name=${requestScope.productName}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/shopping?command=productList&nowPage=${num}">${num}</a></li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${requestScope.paging.nextPageGroup}">
					<li class="page-item"><c:choose>
							<c:when test="${requestScope.productName != null}">
								<a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=productFindByList&nowPage=${paging.endGroup+1}&name=${requestScope.productName}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
							</c:when>
							<c:otherwise>
								<a class="page-link"
									href="${pageContext.request.contextPath}/shopping?command=productList&nowPage=${paging.endGroup+1}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
							</c:otherwise>
						</c:choose></li>
				</c:if>
			</ul>
		</nav>
		<input type="button" value="상품추가"
			onclick="location.href='${pageContext.request.contextPath}/shopping?command=productInsertForm'"> <input
			type="submit" value="상품삭제">
	</form>
	<%-- 상품정보 끝 --%>
</div>
