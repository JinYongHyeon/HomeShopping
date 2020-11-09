<%@page import="org.shopping.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
</head>
<body>
	<%
		if (request.getAttribute("product") == null) {
	%>
		<script type="text/javascript">
			alert("잘못 들어오셨습니다.");
			location.href="index.jsp";
		</script>
	<%
		} else {
		ProductVO vo = (ProductVO) request.getAttribute("product");
	%>
		<form action="shopping" method="post">
		<input type="hidden" name="command" value="productUpdate"> 
		<input type="text" name="no" value="${requestScope.product.no}" readonly="readonly">
		<input type="text" name="name" value="${requestScope.product.name}" required="required" placeholder="상품명을 입력해주세요">
		<input type="number" name="price" value="${requestScope.product.price}" required="required" placeholder="상품가격을 입력해주세요">
		<input type="text" name="imgPath" value="${requestScope.product.imgPath}" required="required" placeholder="상품명을 입력해주세요">
		<input type="number" name="count" value="${requestScope.product.possesionCount}" required="required" placeholder="재고량 입력해주세요">
		<input type="text" name="kind" value="<%=vo.getKinds() %>" required="required" placeholder="상품종류을 입력해주세요">
		<input type="text" name="productNew" value="<%=vo.getProductNew() %>" required="required" placeholder="신상 유무을 입력해주세요">
		<input type="submit" value="상품수정">
		</form>
	<%
		}
	%>
</body>
</html>