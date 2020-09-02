<%@page import="java.util.ArrayList"%>
<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="stylesheet" type="text/css" href="resources/style/css.css">
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
	<span><a href="shopping?command=userList">유저 정보</a></span>
	<span>상품 정보</span>
	<div class="container">
		<form action="shopping" method="get">
			<input type="hidden" name="command" value="userFindByList"> 
			<input type="text" name="id" required="required" placeholder="검색 할 아이디를 입력해주세요"> 
			<input type="submit" value="검색">
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
				<%
					if (request.getAttribute("list") != null) {
					ArrayList<UserVO> userList = (ArrayList<UserVO>) request.getAttribute("list");
					for (int i = 0; i < userList.size(); i++) {
				%>
				<tr>
					<td><%=userList.get(i).getId()%></td>
					<td><%=userList.get(i).getPassword()%></td>
					<td><%=userList.get(i).getName()%></td>
					<td><%=userList.get(i).getTel()%></td>
					<td><%=userList.get(i).getAddress()%></td>
					<td><%=userList.get(i).getEmail()%></td>
					<td><%=userList.get(i).getTotalBuy()%></td>
				</tr>
				<%
					}
				} else if (request.getAttribute("user") != null) {
					if (request.getAttribute("user").equals("null")) {
				%>
				<tr>
					<td colspan="6">회원정보가 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
					UserVO vo = (UserVO) request.getAttribute("user");
				%>
				<tr>
					<td><%=vo.getId()%></td>
					<td><%=vo.getPassword()%></td>
					<td><%=vo.getName()%></td>
					<td><%=vo.getTel()%></td>
					<td><%=vo.getAddress()%></td>
					<td><%=vo.getEmail() %></td>
					<td><%=vo.getTotalBuy()%></td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>