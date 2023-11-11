<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Модальное окно -->
<div id="myModal" class="modal">

  <!-- Модальное содержание -->
  <div class="modal-content">
    <h1 id="result">Результаты теста</h1>
    <p>Отлично! Вы ответили на все вопросы и подтвердили право на собственность.</p><br/>
    <table>
    <tr>
        <td>
        	<form name="Finds" method="POST" action="/Lost-And-Found/findings">
					<input type="hidden" name="command" value="findings" /> 
					<input type="hidden" name="client" value="user" />
					<button id="exit" name="backToFinds" type="submit">Назад</button>
			</form>
        </td>
        <td>
	        <form name="MyFinds" method="POST" action="/Lost-And-Found/myfindings">
				<input type="hidden" name="command" value="myfindings" /> 
				<input type="hidden" name="client" value="user" />
				<button id="toMyFindings" type="submit">К моим находкам</button>
			</form>
    </tr>
</table>
    
    
  </div>

</div>
  
<script>
	//Получить модальное окно
	var modal = document.getElementById("myModal");
	
	// Получить кнопку, которая открывает модальное окно
	var btn = document.getElementById("checkAnswer");
	
	// Получить кнопку, которая закрывает модальное окно
	var btnExit = document.getElementById("exit");
	
	// Когда пользователь нажимает на кнопку, открывается модальное окно
	btn.onclick = function() {
	  modal.style.display = "block";
	}

	// Когда пользователь нажимает на кнопку, закрывается модальное окно
	btnExit.onclick = function() {
	  modal.style.display = "none";
	}
	
	// Когда пользователь щелкает в любом месте за пределами модального, все блокируется
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "block";
	  }
	}
</script>