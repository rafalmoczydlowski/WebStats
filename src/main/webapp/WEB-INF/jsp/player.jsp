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
        <form method="post">
            <fieldset class="form-group">
                <legend>Player's name &darr;</legend>
                <input name="name" type="text" class="form-control" required="required"/>
            </fieldset>
            <fieldset class="form-group">
                <legend>Player's surname &darr;</legend>
                <input name="surname" type="text" class="form-control" required="required"/>
            </fieldset>
            <fieldset class="form-group">
                <legend>Name of the club &darr;</legend>
                <input name="club" type="text" class="form-control" required="required"/>
            </fieldset>

            <button type="submit" class="btn btn-success">ADD</button>
        </form>
    </div>
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>