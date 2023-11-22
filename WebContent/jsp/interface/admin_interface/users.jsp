<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.SystemUser"%>
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
		<jsp:include page="/jsp/interface/admin_interface/header.jsp" />
	<div class="content">
			
	
	 <button id="scrollToBottomButton"><img src="<%= request.getContextPath() %>/images/down.png" alt="Вниз"></button>
	
	    <!-- Другой контент страницы здесь -->
	
	 
			<%
				List<SystemUser> systemUsers = (List<SystemUser>) request.getAttribute("foundUsers");
				for (SystemUser user : systemUsers) {
			%>
		
		
	
	    <table item="users" width="50%">
	        <tr>
	            <td><img src="<%= request.getContextPath() %>/images/user.png" alt="Фото пользователя"></td>
	            <td item="itemusers"><%= user.getFullName() %> 
	            <img id="statusImage<%= user.getUserID() %>" src="<%= user.getStatus().equals("Активен") ? request.getContextPath() + "/images/unlock.png" : request.getContextPath() + "/images/lock.png" %>" alt="Статус"></td>
	            <td item="itemusers">Логин</td>
	            <td item="itemusers">Пароль
	                <button item="activity" type="button" onclick="togglePassword(this, '<%= user.getPassword() %>')">
	                    <img src="<%= request.getContextPath() %>/images/seem.png" alt="На главную">
	                </button>
	            </td>
	        </tr>
	        <tr>
	            <td></td>
	            <td item="role"><%= user.getGroup() %></td>
	            <td><%= user.getLogin() %></td>
	            <td>
	                <span class="passwordField"><%= new String(new char[user.getPassword().length()]).replace('\0', '*') %></span>
	            </td>
	        </tr>
	        <tr>
	            <td></td>
	            <td item="itemusers2"><%= user.getEmail() %></td>
	        </tr>
				<tr>
					<td></td>
					<td colspan="1">
						<div style="display: flex;">
							<form id="myForm" name="BlockButton" method="POST" action="users">
								<input type="hidden" name="command" value="blockuser" /> 
								<input type="hidden" name="client" value="admin" />
								<input type="hidden" name="userid" value="<%=user.getUserID()%>" />
								<button item="actionbutton" type="submit" name="action">
									<%=user.getStatus().equals("Активен") ? "Заблокировать" : "Разблокировать"%>
								</button>
							</form>
							<form name="DeleteButton" method="POST" action="users">
								<input type="hidden" name="command" value="deleteuser" />
								<input type="hidden" name="client" value="admin" />
								<input type="hidden" name="userid" value="<%=user.getUserID()%>" />
								<button item="actionbutton" type="submit" name="action"
									value="delete">Удалить</button>
							</form>
							<form name="ChangeButton" method="POST" action="users/changeuser">
								<input type="hidden" name="command" value="changeuser" />
								<input type="hidden" name="client" value="admin" />
								<input type="hidden" name="userid" value="<%=user.getUserID()%>" />
								<button item="actionbutton" type="submit" name="action"
									value="delete">Изменить</button>
							</form>
						</div>
					</td>
				</tr>
			</table>

    <script>
    function togglePassword(button, password) {
        var passwordField = button.closest('table').querySelector('.passwordField');
        var passwordImage = button.querySelector('img');
        var isPasswordVisible = passwordField.innerText === password;

        if (isPasswordVisible) {
            // Переключаем на звездочки
            passwordField.innerText = '*'.repeat(password.length);
            passwordImage.src = '<%= request.getContextPath() %>/images/notseem.png';
        } else {
            // Переключаем на исходный пароль
            passwordField.innerText = password;
            passwordImage.src = '<%= request.getContextPath() %>/images/seem.png';
        }
    }
    function scrollToBottom() {
        window.scrollTo(0, document.body.scrollHeight);
    }

    // Получаем кнопку
    var scrollToBottomButton = document.getElementById("scrollToBottomButton");

    // Назначаем обработч  ик события при нажатии на кнопку
    scrollToBottomButton.addEventListener("click", scrollToBottom);   
  
    </script>
    

<% } %>


	<div class="addusercontainer">
		<form name="AddButton" method="POST" action="users/adduser">
			<input type="hidden" name="command" value="adduser" /> <input
				type="hidden" name="btn" value="block" /> <input type="hidden"
				name="client" value="admin" />
			<button item="adduserbutton" type="submit" name="action">
				Добавить пользователя</button>
		</form>
	</div>

</div>

<jsp:include page="/jsp/interface/admin_interface/footer.jsp" />
</body>
</html>