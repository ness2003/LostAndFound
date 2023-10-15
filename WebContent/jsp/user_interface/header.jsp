<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="menu">
	<li>
		<form name="Finds" method="POST" action="finds">
			<input type="hidden" name="command" value="finds" /> 
			<input type="hidden" name="client" value="user" />
			<input type="hidden" name="isuserfinds" value="" />
			<button type="submit">Каталог находок</button>
		</form>
	</li>
	
	<li>
		<form name="MyFinds" method="POST" action="myfindings">
			<input type="hidden" name="command" value="finds" /> 
			<input type="hidden" name="client" value="user" />
			<input type="hidden" name="isuserfinds" value="true" />
			<button type="submit">Мои находки</button>
		</form>
	</li>
	
	<li>
		<form name="AboutProject" method="POST" action="aboutproject">
			<input type="hidden" name="command" value="aboutproject" /> 
			<input type="hidden" name="client" value="user" />
			<button type="submit">О проекте</button>
		</form>
	</li>
	
	<li>
		<form name="MyProfile" method="POST" action="myprofile">
			<input type="hidden" name="command" value="myprofile" /> 
			<input type="hidden" name="client" value="user" />
			<button type="submit">Мой профиль</button>
		</form>
	</li>
	
	<li>
		<form name="LogOut" method="POST" action="home">
			<input type="hidden" name="command" value="logout" /> 
			<input type="hidden" name="client" value="user" />
			<button type="submit">Выйти</button>
		</form>
	</li>
	
</ul>