<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="datalayer.data.Finding" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <style>
        <jsp:include page="./styles.css" />
    </style>
    <title>Редактирование находки</title>
</head>
<body>
    <% Finding finding = (Finding)request.getAttribute("finding"); %>
    <div class="changefinding">
        <form id="changefindingForm" name="changefindingForm" method="POST" action="/Lost-And-Found/findings" accept-charset="UTF-8">
            <input type="hidden" name="command" value="refreshFindings" />
            <input type="hidden" name="act" value="edit" />
            <input type="hidden" name="findingid" value="<%=finding.getId()%>" />
            <!-- Наименование находки -->
            <label for="findingName">Наименование находки:</label>
            <input id="findingName" type="text" required name="findingName" value="<%= finding.getName() %>" /><br />

            <!-- Описание находки -->
            <label for="findingDescription">Описание находки:</label>
            <textarea id="findingDescription" required name="findingDescription"><%= finding.getDescription() %></textarea><br />

            <!-- Дата находки -->
            <label for="findingDate">Дата находки:</label>
            <input id="findingDate" type="date" required name="findingDate" value="<%=finding.getDate() %>" /><br />

            <!-- Место находки -->
            <label for="findingLocation">Место находки:</label>
            <input id="findingLocation" type="text" required name="findingLocation" value="<%= finding.getPlace() %>" /><br />

            <!-- Категория находки -->
            <label for="findingCategory">Категория находки:</label>
            <select id="findingCategory" name="findingCategory">
                <option value="Драгоценности и ювелирные изделия" <% if (finding.getCategory().equals("Драгоценности и ювелирные изделия")) { %>selected<% } %>>Драгоценности и ювелирные изделия</option>
                <option value="Личные вещи" <% if (finding.getCategory().equals("Личные вещи")) { %>selected<% } %>>Личные вещи</option>
                <option value="Технические устройства" <% if (finding.getCategory().equals("Технические устройства")) { %>selected<% } %>>Технические устройства</option>
                <!-- Добавьте остальные категории здесь -->
            </select><br />

            <button item="actionbutton2" type="submit">Сохранить изменения</button>
        </form>
    </div>

    <jsp:include page="/jsp/interface/moderator_interface/footer.jsp" />

</body>
</html>
