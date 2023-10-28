<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.FinalQuestion"%>
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
	<jsp:include page="/jsp/interface/moderator_interface/header.jsp" />
	
<div class="finalquestionclass ">


	<% List<FinalQuestion> foundItems = (List<FinalQuestion>) request.getAttribute("foundItems");
     for (FinalQuestion finalQuestion : foundItems) { %>


	<table item="finalquestion" width="50%" >
		<tr>
			<td item="question"><%= finalQuestion.getQuestion()%></td>
			
		
		</tr>
		<tr>
			<td item="rightanswer"><%= finalQuestion.getRightAnswer() %></td>
		</tr>
		<tr>
			<td item="alternativeanswer"><%= finalQuestion.getAlternativeAnswer1() %></td>

		</tr>
		<tr>
			<td item="alternativeanswer"><%= finalQuestion.getAlternativeAnswer2() %></td>
						
		</tr>
		<tr>
			<td colspan="1">
					<div style="text-align: center;">
						<form name="ChangeButton" method="POST" action=finalquestions/changefinalquestion>
							<input type="hidden" name="command" value="changefinalquestion" /> 
							<input type="hidden" name="client" value="moderator" />
							<input type="hidden" name="finalquestionid" value="<%= finalQuestion.getId()%>" />
							<button item="actionbutton" type="submit" name="action"
							value="changefinding">Изменить</button>
						</form>
					</div>
				</td>
		</tr>
	</table>

	<% } %>
</div>
<jsp:include page="/jsp/interface/moderator_interface/footer.jsp" />
</body>
</html>