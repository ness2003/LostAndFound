<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<style>
	<jsp:include page="./styles.css"/>
</style>
<title>Insert title here</title>
</head>
<body>
<div class="adduser">
<form id="addUserForm" name="addUserForm" method="POST" action="/Lost-And-Found/users" accept-charset="UTF-8">
	<input type="hidden" name="client" value="admin" />
	<input type="hidden" name="command" value="refreshUsers" />
	<input type="hidden" name="act" value="add" />  
    <!-- ФИО -->
    <label for="fullName">ФИО:</label>
    <input id="fullName" type="text" required name="fullName" value="" /><br />

    <!-- Номер телефона (начинается с +7) -->
    <label for="phoneNumber">Номер телефона:</label>
    <input id="phoneNumber" type="text" required name="phoneNumber" pattern="^\+7\d{10}$" placeholder="+79991234567" /><br />

    <!-- Email -->
    <label for="email">Email:</label>
    <input id="email" type="email" required name="email" value="" /><br />

    <!-- Логин -->
    <label for="login">Логин:</label>
    <input id="login" type="text" required name="login" value="" /><br />

    <!-- Пароль -->
    <label for="password">Пароль:</label>
    <input id="password" type="password" required name="password" value="" /><br />

    <!-- Статус -->
    <label for="status">Статус:</label>
    <select id="status" name="status">
        <option value="Активен">Активен</option>
        <option value="Заблокирован">Заблокирован</option>
    </select><br />

    <!-- Группа -->
    <label for="group">Группа:</label>
    <select id="group" name="group">
        <option value="Администратор">Администратор</option>
        <option value="Модератор">Модератор</option>
        <option value="Клиент">Клиент</option>
        <option value="Приемщик">Приемщик</option>
    </select><br />
	<button item="actionbutton" type="submit">Добавить пользователя</button>
    <!-- <input id="loginbutton" type="submit" value="Добавить пользователя" /> -->
</form>
</div>

<jsp:include page="/jsp/interface/admin_interface/footer.jsp" />

</body>
</html>