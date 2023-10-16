<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<style>
body {
	font-family: century gothic;
	background-color: #333;
	margin: 0;
	padding: 0;
}

h1#lostandfound {
	font-size: 60px;
	color: #fff;
	margin-top: 10%;
	margin-left: 37%;
}

form#loginform {
	max-width: 300px;
	margin-top: 5%;
	margin-left: 40%;
	background-color: #ffffff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

input#login, input#password {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input#loginbutton {
	margin-top: 4%;
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 3px;
	cursor: pointer;
}

input#loginbutton:hover {
	background-color: #0085FF;
}

.error-message {
	color: red;
	font-weight: bold;
	margin-top: 10px;
}

.invalidPassword {
	color: red;
	margin-top: 10px;
}

</style>
<title>Login</title>
</head>

<body>
	<h1 id="lostandfound">Бюро находок</h1>
	<form id="loginform" name="loginForm" method="POST" action="home">
		<input type="hidden" name="command" value="login" /> Login:<br /> <input
			id="login" type="text" required name="login" value="" /> <br />Password:<br />
		<input id="password" type="password" required name="password" value="" />
		<br><div class="invalidPassword"> ${errorLoginPassMessage} </div>
		<input id="loginbutton" type="submit"
			value="Log in" />
	</form>
</body>

</html>