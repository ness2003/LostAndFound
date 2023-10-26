<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="header">
 		<tr>
          <td id="buttonHome">
          <form name="Home" method="POST" action="home">
			<input type="hidden" name="command" value="home" /> 
			<input type="hidden" name="client" value="admin" />
			<button id="home" type="submit"><img src="<%= request.getContextPath() %>/images/home.png" alt="На главную"></button>
		</form></td>
			<td id="users">
          <form name="Users" method="POST" action="users">
			<input type="hidden" name="command" value="users" /> 
			<input type="hidden" name="client" value="admin" />
			<button id="finds" type="submit">Пользователи</button>
		</form>
          </td>
			<td id="aboutProject">
              <form name="MyTasks" method="POST" action="mytasks">
			<input type="hidden" name="command" value="mytasks" /> 
			<input type="hidden" name="client" value="admin" />
			<button id="mytasks" type="submit">Мои задачи</button>
		</form>
          </td>
			<td id="profile">
              <form name="MyProfile" method="POST" action="myprofile">
			<input type="hidden" name="command" value="myprofile" /> 
			<input type="hidden" name="client" value="admin" />
			<button id="profile" type="submit">Мой профиль</button>
		</form>
          </td>
			<td id="logout">
              <form name="LogOut" method="POST" action="home">
			<input type="hidden" name="command" value="logout" /> 
			<input type="hidden" name="client" value="admin" />
			<button id="logout" type="submit"><img src="<%= request.getContextPath() %>/images/logout.png" alt="Выйти"></button>
		</form>
          </td>
			
		</tr>
  </table>