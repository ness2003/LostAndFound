<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.Finding"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
		<style>
			<jsp:include page="./styles.css"/>
		</style>
</head>

<body>
	<jsp:include page="/jsp/user_interface/header.jsp" />


	<% List<Finding> foundItems = (List<Finding>) request.getAttribute("foundItems");
     for (Finding finding : foundItems) { %>


	<table item="finding" width="90%">
		<tr>
			<td item="category"><%= finding.getCategory() %></td>
			<td item="description" rowspan="4"><%= finding.getDescription() %></td>
			<td rowspan="4"><button item="ownership" type="submit">
					Оформить<br>право<br>собственности
				</button></td>
		</tr>
		<tr>
			<td item="date"><%= finding.getDate() %></td>
		</tr>
		<tr>
			<td item="name"><%= finding.getName() %></td>
		</tr>
		<tr>
			<td item="place"><%= finding.getPlace() %></td>
		</tr>
	</table>

	<% } %>

</body>
</html>