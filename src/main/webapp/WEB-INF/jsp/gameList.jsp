<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Status</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${games}" var="game">
        <jsp:useBean id="game" scope="page" type="my.testtasks.games.model.Game"/>
        <tr>
            <td>${game.id}</td>
            <td>${game.name}</td>
            <td>${game.status.toString()}</td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>