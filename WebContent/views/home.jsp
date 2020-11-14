<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${sessionScope.user != null}">
		${sessionScope.user.name}님 안녕하세요
	<a href="${pageContext.request.contextPath}/shopping?command=userLogout">로그아웃</a>
		<a href="${pageContext.request.contextPath}/shopping?command=userImformationFrom">개인정보</a>
		<c:if test="${sessionScope.user.id=='admin'}">
			<a href="${pageContext.request.contextPath}/shopping?command=userList">관리자 페이지</a>
		</c:if>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/shopping?command=userLoginForm">로그인</a>
		<a href="${pageContext.request.contextPath}/shopping?command=userSingUpForm">회원가입</a>
	</c:otherwise>
</c:choose>


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
	<div id="newProductForm">
		<h1>NEW LIST</h1>
		<div class="productList">
			<c:forEach items="${requestScope.hotList}" var="hot">
				<div class="product">
						<img src="${pageContext.request.contextPath}/resources/img/product/main/${hot.productMainImg}" class="carf-img-top" alt="">
						<div class="productBody">
							<h5>${hot.productName}</h5>
							<p>${hot.productPrice}</p>
						</div>
				</div><%-- product --%>
			</c:forEach>
		</div><%--productList --%>
	</div><%--  newProductForm --%>
</div><%-- container --%>

<div id="hotProductForm">
	<h1>HOT LIST</h1>
</div>

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
		console.log(sno, no);

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
</script>