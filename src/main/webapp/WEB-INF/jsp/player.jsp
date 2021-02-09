<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebStats</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <%--@elvariable id="player" type="com.rafinha.webstats.model.Player"--%>
        <form:form method="post" modelAttribute="player">
            <fieldset class="form-group">
                <form:label path="name">Player's name &darr;</form:label>
                <form:input path="name" type="text" class="form-control"/>
                <form:errors path="name" cssClass="text-danger"/>
            </fieldset>
            <fieldset class="form-group">
                <form:label path="surname">Player's surname &darr;</form:label>
                <form:input path="surname" type="text" class="form-control"/>
                <form:errors path="surname" cssClass="text-danger"/>
            </fieldset>
            <fieldset class="form-group">
                <form:label path="club">Name of the club &darr;</form:label>
                <form:input path="club" type="text" class="form-control"/>
                <form:errors path="club" cssClass="text-danger"/>
            </fieldset>

            <button type="submit" class="btn btn-success">ADD</button>
        </form:form>
    </div>
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>