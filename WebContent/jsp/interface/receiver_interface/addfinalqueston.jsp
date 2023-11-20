<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		<jsp:include page="./styles.css"/>
	</style>
<title>Добавление контрольного вопроса</title>
</head>
<body>

<h1>Добавление контрольного вопроса</h1>

<div class="addFinalQuestion">
	
        
        <label for="question">Вопрос:</label>
        <input id="question" type="text" required name="question" value="" /><br />

        <label for="alternativeAnswer1">Правильный ответ:</label>
        <input id="rightAnswer" type="text" required name="rightAnswer" value="" /><br />
 
        <!-- Альтернативный ответ 1 -->
        <label for="alternativeAnswer1">Альтернативный ответ 1:</label>
        <input id="alternativeAnswer1" type="text" required name="alternativeAnswer1" value="" /><br />

        <!-- Альтернативный ответ 2 -->
        <label for="alternativeAnswer2">Альтернативный ответ 2:</label>	
        <input id="alternativeAnswer2" type="text" required name="alternativeAnswer2" value="" /><br />
        
	<form id="addFinalQuestionForm" method="POST" action="/Lost-And-Found/findings/finalquestions" accept-charset="UTF-8">
        <input type="hidden" name="command" value="RefreshFinalQuestion" />
        <input type="hidden" name="client" value="receiver" />
        <button id="saveFinalQuestion" type="submit">Сохранить</button>
        
 	</form>
 	
 		<button id="saveAndAddNextFinalQuestion" type="submit">Добавить ещё</button>
</div>

</body>
</html>