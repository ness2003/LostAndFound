<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="temporary.data.QuestionAnswer"%>
<%@ page import="temporary.data.QuestionAnswer.Answer"%>
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

	<h1>Пожалуйста, ответьте на контрольные вопросы</h1>
	
	<% List<QuestionAnswer> foundItems = (List<QuestionAnswer>) request.getAttribute("foundQuestionAnswer");
	int count = 0;
	int group = 0;
	for (QuestionAnswer questionAnswer : foundItems) { %>


	<table>
		<tr>
			<td id="question" colspan="2"><%= questionAnswer.getQuestion()%></td>
		</tr>
		<tr id="answer">
			<td colspan="2">
			<% List<Answer> answers = questionAnswer.getAnswers();
			for (Answer answer : answers) { %>
			
				
					<input id="answer<%= count%>" name="AnswerGroup<%= group%>" type="radio" value="<%= answer.isCorrect()%>" />
					<label id="answer" for="answer<%= count++%>"><%= answer.getText()%></label><br>
	
			<% } %>
			</td>	
		</tr>
		
		<% group++;
		} %>

		<tr id="answer">
			<td>
				<form name="Finds" method="POST" action="/Lost-And-Found/findings">
					<input type="hidden" name="command" value="findings" /> 
					<input type="hidden" name="client" value="user" />
					<button id="question" name="backToFinds" type="submit">Назад</button>
				</form>
			</td>
			<td>
				<form name="CheckAnswer" method="POST" action="/Lost-And-Found/findings">
					<input type="hidden" name="command" value="checkanswer" /> 
					<input type="hidden" name="client" value="user" />
					<button id="question" name="checkAnswer" type="submit">Проверить</button>
				</form>
			</td>
		</tr>
	</table>

	
	<jsp:include page="/jsp/interface/user_interface/result.jsp" />
</body>


</html>