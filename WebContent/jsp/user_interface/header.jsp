<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="header">
 		<tr>
          <td id="buttonHome">
          <form name="Home" method="POST" action="home">
			<input type="hidden" name="command" value="home" /> 
			<input type="hidden" name="client" value="user" />
			<button id="home" type="submit"><img src="<%= request.getContextPath() %>/images/home.png" alt="На главную"></button>
		</form></td>
			<td id="finds">
          <form name="Finds" method="POST" action="finds">
			<input type="hidden" name="command" value="finds" /> 
			<input type="hidden" name="client" value="user" />
			<input type="hidden" name="isuserfinds" value="" />
			<button id="finds" type="submit">Каталог находок</button>
		</form>
          </td>
			<td id="myFindings">
          <form name="MyFinds" method="POST" action="myfindings">
			<input type="hidden" name="command" value="finds" /> 
			<input type="hidden" name="client" value="user" />
			<input type="hidden" name="isuserfinds" value="true" />
			<button id="myFindings" type="submit">Мои находки</button>
		</form>
          </td>
			<td id="aboutProject">
              <form name="AboutProject" method="POST" action="aboutproject">
			<input type="hidden" name="command" value="aboutproject" /> 
			<input type="hidden" name="client" value="user" />
			<button id="aboutProject" type="submit">О проекте</button>
		</form>
          </td>
			<td id="profile">
              <form name="MyProfile" method="POST" action="myprofile">
			<input type="hidden" name="command" value="myprofile" /> 
			<input type="hidden" name="client" value="user" />
			<button id="profile" type="submit">Мой профиль</button>
		</form>
          </td>
			<td id="logout">
              <form name="LogOut" method="POST" action="home">
			<input type="hidden" name="command" value="logout" /> 
			<input type="hidden" name="client" value="user" />
			<button id="logout" type="submit"><img src="<%= request.getContextPath() %>/images/logout.png" alt="Выйти"></button>
		</form>
          </td>
			
		</tr>
  </table>