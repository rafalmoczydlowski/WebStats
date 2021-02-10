<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
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
<%@include file="common/footer.jspf"%>