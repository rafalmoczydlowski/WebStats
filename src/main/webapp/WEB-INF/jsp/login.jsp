<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebStats</title>
</head>
<body>
<form method="post">
    Name: <input type="text" name="name"/>
    Password: <input type="password" name="password"/>
    <input type="submit"/>
</form>
<span style="color: red; ">${validationErrorMessage}</span>
</body>
</html>