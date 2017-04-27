<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>
<h1>TicTacToe Game</h1>
<br>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Status</th>
    </tr>
    </thead>
    <c:forEach items="${games}" var="game">
        <jsp:useBean id="game" scope="page" type="my.testtasks.games.model.Game"/>
        <tr>
            <td><a href="/game/${game.id}">${game.name}</a></td>
            <td>${game.status.toString()}</td>
        </tr>
    </c:forEach>
</table>
<br>
<form id="form" method="post">
    Game name: <input type="text" name="gameName" value="Game ${games.size()+1}">
    <input type="submit" value="Add game" id="btnAdd" name="btnAdd"/>
</form>

</body>
</html>