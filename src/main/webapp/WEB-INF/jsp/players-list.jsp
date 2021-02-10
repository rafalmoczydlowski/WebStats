<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
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
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${players}" var="player">
                <tr>
                    <td>${player.name}</td>
                    <td>${player.surname}</td>
                    <td>${player.club}</td>
                    <td><a type="button" class="btn btn-success" href="/update-player?id=${player.id}">Update</a></td>
                    <td><a type="button" class="btn btn-warning" href="/delete-player?id=${player.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div><a class="button" href="/add-player">Add a player to the database</a></div>
    </div>
<%@include file="common/footer.jspf"%>