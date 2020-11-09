<%@page import="org.shopping.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<jsp:forward page="/shopping">
	<jsp:param value="home" name="command"/>
</jsp:forward>