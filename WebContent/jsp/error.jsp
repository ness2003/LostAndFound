<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Error Page</title>
<style>
body {
	background-color: #333;
	font-family: century gothic;
	font-size: 15px;
	color: #fff;
}

body#errorPage {
	background-color: #333;
	font-family: century gothic;
	font-size: 30px;
	color: #fff;
	margin-top: 10%;
	margin-left: 10%;
}


</style>
</head>

<body id="errorPage">
	<h1>Кажется, что-то сломалось...</h1>
	Request from ${pageContext.errorData.requestURI} is failed
	<br /> Servlet name or type: ${pageContext.errorData.servletName}
	<br /> Status code: ${pageContext.errorData.statusCode}
	<br /> Exception: ${pageContext.errorData.throwable}
</body>
</html>