<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebStats</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <H1>Players in database</H1>
        <table class="table table-striped">
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

        <div><a class="button" href="add-player">Add a player to the database</a></div>

        <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </div>
</body>
</html>