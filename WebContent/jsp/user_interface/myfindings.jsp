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
			
			ul.menu li a {
				display: block;
				color: #fff;
				text-decoration: none;
				padding: 10px 20px;
			}
			
			ul.menu li a:hover {
				background-color: #7DA980;
			}
			
			/* Пространство для контента */
			.content {
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
			
			table {
				width: 80%; /* Установите желаемую ширину таблицы */
				border-collapse: collapse; /* Объединение границ ячеек таблицы */
			}
			
			th, td {
				border: 1px solid #000; /* Стиль границы ячеек */
				padding: 8px; /* Отступ внутри ячеек */
			}
			
			th {
				background-color: #f2f2f2; /* Фон заголовков столбцов */
			}
		</style>
	</head>
	<body>
		<jsp:include page="/jsp/user_interface/header.jsp" />
		<div class="content">
			<h1>Это все ваши находки:</h1>
			<table border="1">
				<tr>
					<th>Наименование</th>
					<th>Описание</th>
					<th>Дата находки</th>
					<th>Место находки</th>
				</tr>
				<c:forEach var="finding" items="${myFindings}">
					<tr>
						<td>${myFindings.name}</td>
						<td>${myFindings.description}</td>
						<td>${myFindings.date}</td>
						<td>${myFindings.location}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
		<jsp:include page="/jsp/user_interface/footer.jsp" />
	</body>
</html>