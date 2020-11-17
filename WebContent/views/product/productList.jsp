<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#productForm{
	 height: 1000px;
	}
</style>
<div id="productForm">
	<div class="productList">
		<c:forEach items="${requestScope.productList}" var="product">
			<div class="product">
				<div class="productImg">
					<img src="${pageContext.request.contextPath}/resources/img/product/main/${product.productMainImg}" class="carf-img-top" alt=""> <a href="${pageContext.request.contextPath}/shopping?command=productDetail&productNo=${product.productNo}"><svg viewBox="0 0 16 16" class="bi bi-zoom-in productZoom" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
  <path d="M10.344 11.742c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1 6.538 6.538 0 0 1-1.398 1.4z" />
  <path fill-rule="evenodd" d="M6.5 3a.5.5 0 0 1 .5.5V6h2.5a.5.5 0 0 1 0 1H7v2.5a.5.5 0 0 1-1 0V7H3.5a.5.5 0 0 1 0-1H6V3.5a.5.5 0 0 1 .5-.5z" />
</svg></a>
				</div>
				<div class="productBody">
					<h5>${product.productName}</h5>
					<p>${product.productPrice}</p>
				</div>
			</div>
			<%-- product --%>
		</c:forEach>
	</div>
	<%-- productList --%>
</div>
<%-- productForm--%>
<nav aria-label="Page navigation example" id="adminPage">
		<ul class="pagination">
			<c:if test="${requestScope.paging.previousPageGroup}">
				<li class="page-item"><c:choose>
						<c:when test="${param.productName != null}">
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userProductFindByList&nowPage=${paging.startGroup-1}&productName=${param.productName}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=productKindList&kind=${param.kind}&nowPage=${paging.startGroup-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
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
							<c:when test="${param.productName != null}">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userProductFindByList&nowPage=${num}&productName=${param.productName}">${num}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/shopping?command=productKindList&kind=${param.kind}&nowPage=${num}">${num}</a></li>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.paging.nextPageGroup}">

				<li class="page-item"><c:choose>
						<c:when test="${param.productName != null}">
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=userProductFindByList&nowPage=${paging.endGroup+1}&productName=${param.productName}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="${pageContext.request.contextPath}/shopping?command=productKindList&kind=${param.kind}&nowPage=${paging.endGroup+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
		</ul>
	</nav>