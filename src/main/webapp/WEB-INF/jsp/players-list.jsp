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
        <br>
        <p id ="table">Players in database</p>
        <table aria-describedby="table" class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Club</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${players}" var="player">
                <tr>
                    <td>${player.name}</td>
                    <td>${player.surname}</td>
                    <td>${player.club}</td>
                    <td><a type="button" class="btn btn-warning" href="/delete-player?id=${player.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div><a class="button" href="/add-player">Add a player to the database</a></div>

        <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </div>
</body>
</html>