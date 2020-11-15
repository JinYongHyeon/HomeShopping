<%@page import="org.shopping.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">

	<div id="adminTopBar">
		<a href="${pageContext.request.contextPath}/shopping?command=userList" style="background-color:#F57F17;
	color:#fff;">유저 정보</a> 
		<a href="${pageContext.request.contextPath}/shopping?command=productList">상품 정보</a>
		<div class="adminSeacrch">
			<%--유저정보 시작 --%>
			<form action="shopping" method="get">
				<input type="hidden" name="command" value="userFindByList"> <input type="text" name="id" required="required" placeholder="검색 할 아이디를 입력해주세요"> <input type="submit" value="검색">
			</form>
		</div>
	</div>
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
	<nav aria-label="Page navigation example" id="adminPage">
		<ul class="pagination">
			<c:if test="${requestScope.paging.previousPageGroup}">
				<li class="page-item"><c:choose>
						<c:when test="${requestScope.id != null}">
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${paging.startGroup-1}&id=${requestScope.id}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${paging.startGroup-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
			<c:forEach begin="${requestScope.paging.startGroup}" end="${requestScope.paging.endGroup}" var="num">
				<c:choose>
					<c:when test="${requestScope.paging.nowPage==num}">
						<li class="page-item active"><a class="page-link" href="#">${num}</a></li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${requestScope.id != null}">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${num}&id=${requestScope.id}">${num}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${num}">${num}</a></li>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.paging.nextPageGroup}">

				<li class="page-item"><c:choose>
						<c:when test="${requestScope.id != null}">
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userFindByList&nowPage=${paging.endGroup+1}&id=${requestScope.id}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userList&nowPage=${paging.endGroup+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
		</ul>
	</nav>
	<%-- 유저정보 끝 --%>
</div>
<%-- container --%>
