<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebStats</title>
</head>
<body>
<H1>Players in database</H1>
<table>
    <caption>PLAYERS</caption>
    <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Club</th>
            <th>Player's id</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${player.name}</td>
            <td>${player.surname}</td>
            <td>${player.club}</td>
            <td>${player.id}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
<a href="add-player">Add a player to the database</a>
</body>
</html>