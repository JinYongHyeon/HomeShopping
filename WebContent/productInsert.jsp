<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
</head>
<body>
	<%
		HttpSession session = request.getSession(false);
	if (session == null) {
	%>
	<script type="text/javascript">
		alert("관리자 전용 페이지입니다 돌아가세요");
		location.href = "index.jsp";
	</script>
	<%
		} else if (session.getAttribute("user") != null) {
		UserVO vo = (UserVO) session.getAttribute("user");
		if (!vo.getId().equals("admin")) {
	%>
	<script type="text/javascript">
		alert("관리자 전용 페이지입니다 돌아가세요");
		location.href = "index.jsp";
	</script>
	<%
		}
	}
	%>
	<form action="shopping" method="post" onsubmit="return produtNewCheck()" enctype="multipart/form-data">
		<input type="hidden" name="command" value="productInsert"> 
		<input type="text" name="name" required="required" placeholder="상품명을 입력해주세요">
		<input type="number" name="price" required="required" placeholder="상품가격을 입력해주세요">
		<textarea name="content" id="content" style="width:100%;"></textarea>
		<input type="file" name="imgPath" required="required" placeholder="이미지 입력해주세요">
		<input type="number" name="count" required="required" placeholder="재고량 입력해주세요" min=1;>
		<input type="text" name="kind" required="required" placeholder="상품종류을 입력해주세요">
		<select name="productNew">
			<option>--신상 유무를 선택해주세요--</option>
			<option>NEW</option>
			<option>NO</option>
		</select>
		<input type="submit" value="상품수정">
		</form>
		<script type="text/javascript" src="resources/javascript/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="resources/javascript/script.js"></script>
		<%-- <script type="text/javascript" src="editor/js/HuskyEZCreator.js"></script>
		
		<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		    oAppRef: oEditors,
		    elPlaceHolder: "content",
		    sSkinURI: "http://localhost:8888/homeShopping/editor/SmartEditor2Skin.html",
		    htParams : {
		          // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		          bUseToolbar : true,             
		          // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		          bUseVerticalResizer : true,     
		          // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		          bUseModeChanger : true,         
           }
		  
		});
	
	
		</script>--%>
</body>
</html>