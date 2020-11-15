<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row" id="productDetail">
		<div class="col-sm-6 productImg">
			<img src="${pageContext.request.contextPath}/resources/img/product/main/${requestScope.product.productMainImg}">
		</div>
		<div class="col-sm-6 productImformation">
			<div class="productName">
				<span>${requestScope.product.kinds}</span>
				<h1>제품 : ${requestScope.product.productName}</h1>
			</div>
			<div class="productPrice">
				<h2>금액 : ${requestScope.product.productPrice}원</h2>
			</div>
			<div class="productCount">
				<h2>남은 수량 : ${requestScope.product.productPossesionCount} 개</h2>
			</div>
			<div class="productBtn">
				<form action="" onsubmit="return purchaseCheck()">
					<input type="number" id="productCount" required="required" placeholder="수량"> <input type="button" id="productCart" value="장바구니"> <input type="submit" value="구매하기">
				</form>
			</div>
		</div>
		<%-- productImformation  --%>
		<div class="col-sm-12 productContent">
			<pre>${requestScope.product.productContent}</pre>
		</div>
	</div>
	<%-- productDetail --%>

</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(document).on("click", "#productCart", function() {
			confirm("${requestScope.product.productName} 장바구니에 담겠습니까?")
		});
	});
	function purchaseCheck() {
		var count = document.getElementById("productCount").value;
		if(count>${requestScope.product.productPossesionCount}){
			alert("재고량 보다 많이 구매하셨습니다.");
			return false;
		}
		return confirm("${requestScope.product.productName} 구매하시겠습니까?");
	}
</script>