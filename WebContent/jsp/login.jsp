<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
	<head>
		<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #333;
			margin: 0;
			padding: 0;
			display: flex;
			justify-content: center; /* Центрирование по горизонтали */
			align-items: center; /* Центрирование по вертикали */
		}
		
		form {
			max-width: 300px;
			margin: 0 auto;
			background-color: #ffffff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
		}
		
		input[type="text"], input[type="password"] {
			width: 100%;
			padding: 10px;
			margin-bottom: 10px;
			border: 1px solid #ccc;
			border-radius: 3px;
		}
		
		input[type="submit"] {
			background-color: #333;
			color: #fff;
			border: none;
			padding: 10px 20px;
			border-radius: 3px;
			cursor: pointer;
		}
		
		input[type="submit"]:hover {
			background-color: #7DA980;
		}
		
		.error-message {
			color: #ff0000;
			font-weight: bold;
			margin-top: 10px;
		}
		</style>
		<title>Login</title>
	</head>
	
	<body>
		<form name="loginForm" method="POST" action="home">
			<input type="hidden" name="command" value="login" /> Login:<br /> 
			<input type="text" required name="login" value="" /> <br />Password:<br /> 
			<input type="password" required name="password" value="" /> <br />
			
			${errorLoginPassMessage} <br /> ${wrongAction} <br /> ${nullPage} <br />
			<input type="submit" value="Log in" />
		</form>
	</body>
	
</html>