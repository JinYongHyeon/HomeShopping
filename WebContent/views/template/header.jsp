<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 headerLogo">
			<a href="${pageContext.request.contextPath}/shopping?command=home"><img src="${pageContext.request.contextPath}/resources/img/main_logo2.png"></a>
		</div>
		<div class="col-sm-7 headerSearch">
			<form action="">
				<input type="text" name="productName" required="required" placeholder="상품이름을 입력해주세요">
				<input type="submit" value="검색">
			</form>
		</div>
		<div class="col-sm-2 headerIcon">
			<ul>
				<li><svg viewBox="0 0 16 16" class="bi bi-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
</svg></li>
				<li><svg viewBox="0 0 16 16" class="bi bi-cart3" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z" />
</svg></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12 menubar ">
			<div class="container">
				<nav>
					<ul>
						<li><a href="">상의</a></li>
						<li><a href="">아우터</a></li>
						<li><a href="">하의</a></li>
						<li><a href="">신발</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>