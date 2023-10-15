<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<style>
			/* Общие стили для страницы */
			body {
				margin: 0;
				padding: 0;
				min-height: 100vh;
				/* Минимальная высота равная высоте видимой области экрана (100% высоты) */
			}
			/* Стили для меню */
			ul.menu {
				list-style-type: none;
				padding: 0;
				background-color: #333;
				position: fixed; /* Фиксированное позиционирование */
				width: 100%;
				top: 0; /* Расположение вверху страницы */
			}
			
			ul.menu li {
				display: inline-block; /* Пункты меню в одной строке */
			}
			
			ul.menu li button {
				display: block;
				color: #fff;
				text-decoration: none;
				padding: 10px 20px;
			}
			
			ul.menu li button:hover {
				background-color: #7DA980;
			}
			
			/* Пространство для контента */
			.finding-form {
				margin-top: 50px; /* Отступ, чтобы контент не перекрывал меню */
				padding: 20px;
			}
			
			footer {
				position: fixed;
				bottom: 0;
				text-align: center;
				padding: 10px 0;
				background-color: #333;
				color: #fff;
				width: 100%;
			}
			
			form {
				border: 1px solid #ccc;
				padding: 10px;
				margin: 10px;
				background-color: #f9f9f9;
			}
			
			h1, h2 {
				color: #333;
			}
		</style>
	</head>
	
	<body>
		<jsp:include page="/jsp/user_interface/header.jsp" />
		<input type="hidden" name="command" value="findings">
		<c:forEach var="finding" items="${findingsList}">
			<div class="finding-form">
				<h1>Активные находки:</h1>
				<form method="post" action="findings">
					<h2>Наименование находки: ${finding.name}</h2>
					<p>Описание: ${finding.description}</p>
					<p>Дата находки: ${finding.date}</p>
					<p>Место находки: ${finding.place}</p>
					<p>Категория находки: ${finding.category}</p>
	
					<input type="hidden" name="command" value="${finding.id}">
	                <input type="submit" value="Оформить право собственности">
				</form>
			</div>
		</c:forEach>
	
		<jsp:include page="/jsp/user_interface/footer.jsp" />
	</body>
</html>