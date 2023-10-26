<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="datalayer.data.SystemUser"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<style>
<jsp:include page="./styles.css"/>
</style>
</head>

<body>
	<jsp:include page="/jsp/interface/user_interface/header.jsp" />



	<% SystemUser systemUser = (SystemUser) request.getAttribute("profileData"); %>




	<h1 id="profile">Профиль пользователя</h1>

	<table id="profile">
	<tr>
		<td id="profileTitle"><strong>ФИО:</strong></td>
		<td id="profileData"><%= systemUser.getFullName()%></td>
	</tr>
	<tr>
		<td id="profileTitle"><strong>Телефон:</strong></td>
		<td id="profileData"><%= systemUser.getPhone() %></td>
	</tr>
	<tr>
		<td id="profileTitle"><strong>Email:</strong></td>
		<td id="profileData"><%= systemUser.getEmail() %></td>
	</tr>
	</table>
	
</body>
</html>