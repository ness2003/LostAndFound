<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Триггер/Открыть модальный -->
<button id="myBtn">Открыть модальный</button>

  <div id="myModal" class="modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLiveLabel" style="display: block;" aria-modal="true" role="dialog">
    <div class="modal-content">
      <span class="close">&times;</span>
      <h1>Результаты теста</h1>
      <p>Отлично! Вы ответили на все вопросы и подтвердили право на собственность.</p><br/>
      <button id="exit" type="submit">Назад</button>
      <button id="myfinds" type="submit">К моим находкам</button>
    </div>
  </div>

  
  
<script>
	//Получить модальный
	var modal = document.getElementById("myModal");
	
	// Получить кнопку, которая открывает модальный
	var btn = document.getElementById("myBtn");
	
	// Получить элемент <span>, который закрывает модальный
	var span = document.getElementsByClassName("close")[0];
	
	var btnExit = document.getElementById("exit");
	
	// Когда пользователь нажимает на кнопку, откройте модальный
	btn.onclick = function() {
	  modal.style.display = "block";
	}
	
	btnExit.onclick = function() {
	  modal.style.display = "none";
	}
	
	// Когда пользователь нажимает на <span> (x), закройте модальное окно
	span.onclick = function() {
	  modal.style.display = "none";
	}
	
	// Когда пользователь щелкает в любом месте за пределами модального, не закрывайте
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "block";
	  }
	}
</script>