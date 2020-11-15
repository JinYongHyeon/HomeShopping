<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- 
	이슈 : 로그인 실패 시 로그인 실패 알림 어떻게 하는지??
	      index.jsp 최조 접근 및 index.jsp 접근 시 DB자료를 어떻게 가져오는가??
--%>
<div class="container">
	<div class="row">
		<div class="col-sm-12" id="mainSlideForm">
			<ul>
				<li></li>
				<li></li>
				<li></li>
			</ul>
			<div class="mainSlideBtn">
				<button onclick="startSlide(0)"></button>
				<button onclick="startSlide(1)"></button>
				<button onclick="startSlide(2)"></button>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div id="productForm">
		<div class="productTitle">
					<h1>NEW LIST</h1>
					<ul>
						<li onclick="newlistSlide('left')">&#60;</li>
						<li onclick="newlistSlide('right')">></li>
					</ul>
		</div>
		<%-- productTitle --%>
		<div class="newProductList">
			<c:forEach items="${requestScope.newList}" var="newProduct">
				<div class="product">
					<div class="productImg">
					<img
						src="${pageContext.request.contextPath}/resources/img/product/main/${newProduct.productMainImg}"
						class="carf-img-top" alt="">
					<a href="${pageContext.request.contextPath}/shopping?command=productDetail&productNo=${newProduct.productNo}"><svg viewBox="0 0 16 16" class="bi bi-zoom-in productZoom" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
  <path d="M10.344 11.742c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1 6.538 6.538 0 0 1-1.398 1.4z"/>
  <path fill-rule="evenodd" d="M6.5 3a.5.5 0 0 1 .5.5V6h2.5a.5.5 0 0 1 0 1H7v2.5a.5.5 0 0 1-1 0V7H3.5a.5.5 0 0 1 0-1H6V3.5a.5.5 0 0 1 .5-.5z"/>
</svg></a>
					</div>
					<div class="productBody">
						<h5>${newProduct.productName}</h5>
						<p>${newProduct.productPrice}</p>
					</div>
				</div><%-- product --%>
			</c:forEach>
		</div>		<%--productList --%>
	</div>	<%--  newProductForm --%>
</div><%-- container --%>

<div class="container">
	<div id="productForm">
		<div class="productTitle">
					<h1>HOT LIST</h1>
					<ul>
						<li onclick="hotlistSlide('left')">&#60;</li>
						<li onclick="hotlistSlide('right')">></li>
					</ul>
		</div>
		<%-- productTitle --%>
		<div class="hotProductList">
			<c:forEach items="${requestScope.hotList}" var="hot">
				<div class="product">
				 <div class="productImg">
					<img
						src="${pageContext.request.contextPath}/resources/img/product/main/${hot.productMainImg}"
						class="carf-img-top" alt="">
					<a href="${pageContext.request.contextPath}/shopping?command=productDetail&productNo=${hot.productNo}"><svg viewBox="0 0 16 16" class="bi bi-zoom-in productZoom" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
  <path d="M10.344 11.742c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1 6.538 6.538 0 0 1-1.398 1.4z"/>
  <path fill-rule="evenodd" d="M6.5 3a.5.5 0 0 1 .5.5V6h2.5a.5.5 0 0 1 0 1H7v2.5a.5.5 0 0 1-1 0V7H3.5a.5.5 0 0 1 0-1H6V3.5a.5.5 0 0 1 .5-.5z"/>
</svg></a>
						</div>
					<div class="productBody">
						<h5>${hot.productName}</h5>
						<p>${hot.productPrice}</p>
					</div>
				</div><%-- product --%>
			</c:forEach>
		</div>		<%--productList --%>
	</div>	<%--  newProductForm --%>
</div><%-- container --%>


<script type="text/javascript">
	$(document).ready(function() {
		onSlide();
	});

	var $slides = $("#mainSlideForm ul li");
	var max = $slides.length - 1;
	var sno = 0;
	var timer = null;

	function onSlide() {
		timer = setTimeout(function() {
			startSlide("right")
		}, 2500);
		$("#mainSlideForm .mainSlideBtn button").eq(sno).addClass("on")
				.siblings().removeClass("on");
	}
	
	function startSlide(a) {
		if ($slides.is(":animated") || a == sno)
			return;
		var no, type;
		clearTimeout(timer);
		if (typeof a == "string") {
			type = a;
			//no= type=="left"?sno==0?max:sno-1:sno==max?0:sno+1;
			if (type == "left") {
				if (sno == 0)
					no = max;
				else
					no = sno - 1;
			} else {
				if (sno == max)
					no = 0;
				else
					no = sno + 1;
			}
		} else {
			no = a;
			type = no < sno ? "left" : "right";
		}

		var leftVal = type == "left" ? -100 : 100;

		$slides.eq(no).css("left", leftVal + "%").animate({
			left : 0
		}, 1000);
		$slides.eq(sno).animate({
			"left" : -leftVal + "%"
		}, 1000);

		sno = no;

		onSlide();
	}
	//최신 상품 
	var newMove = 0;
	var newNo = 0;
	function newlistSlide(action) {
		if ($(".newProductList").is(":animated"))
			return;
		if (action === "left") {
			if (newNo > 0) {
				--newNo;
				newMove = newMove + 330;
			}
		} else {
			if (newNo <= 5) {
				++newNo;
				newMove = newMove - 330;
			}
		}
	$(".newProductList").animate({
		"left" : newMove + "px"
	}, 1000);}
	
	//핫 상품
	var hotMove = 0;
	var hotNo = 0;
	
	function hotlistSlide(action) {
		if ($(".hotProductList").is(":animated"))
			return;
		if (action === "left") {
			if (hotNo > 0) {
				--hotNo;
				hotMove = hotMove + 330;
			}
		} else {
			if (hotNo <= 5) {
				++hotNo;
				hotMove = hotMove - 330;
			}
		}
	$(".hotProductList").animate({
		"left" : hotMove + "px"
	}, 1000);}
</script>