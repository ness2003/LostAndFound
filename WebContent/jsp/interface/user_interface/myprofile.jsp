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

	<form name="saveProfileData" method="POST" action="myprofile" accept-charset="UTF-8">
    <input type="hidden" name="command" value="myprofile" />
    <input type="hidden" name="client" value="user" />
    <input type="hidden" name="data" value="refresh" />
    <input type="hidden" name="userid" value="<%=systemUser.getUserID()%>" />
  
        
		<table id="profile">
		<tr>
			<td><label id="profileTitle" for="profileDataName">ФИО</label></td>
			<td><input id="profileDataName" name="name" type="text" value="<%= systemUser.getFullName()%>"></td>
		</tr>
		<tr>
			<td><label id="profileTitle" for="profileDataPhone">Телефон</label></td>
			<td><input id="profileDataPhone" name="phone" type="text" value="<%= systemUser.getPhone() %>"></td>
		</tr>
		<tr>
			<td><label id="profileTitle" for="profileDataEmail">Email</label></td>
			<td><input id="profileDataEmail" name="email" type="text" value="<%= systemUser.getEmail() %>"></td>
		</tr>
		<tr>
			<td colspan="2"><button id="saveProfileData" type="submit">Сохранить изменения</button></td>
		</tr>
		<% if(request.getAttribute("saveMessage").equals("yes")) {%>
		<tr>
			<td colspan="2"><p id="saveMessage">Данные успешно сохранены!</p></td>
		</tr>
		<%}%>
		</table>
	
	
	</form>
	
	<jsp:include page="/jsp/interface/user_interface/footer.jsp" />
</body>
</html>