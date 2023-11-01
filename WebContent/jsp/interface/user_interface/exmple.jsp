<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<style>
			<jsp:include page="./styles.css"/>
		</style>
</head>
<body>
	<button id="openModalBtn">Открыть модальное окно</button>

	<div id="myModal" class="modal">
		<div class="modal-content">
			<button id="closeModalBtn" type="submit">&times;</button>

			

		</div>
	</div>

	<script>
		// Открывает модальное окно
		document.getElementById("openModalBtn").addEventListener("click",
				function() {
					document.getElementById("myModal").style.display = "block";
				});

		// Закрывает модальное окно
		document.getElementById("closeModalBtn").addEventListener("click",
				function() {
					document.getElementById("myModal").style.display = "none";
				});
	</script>

</body>
</html>