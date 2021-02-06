<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebStats</title>
</head>
<body>
Dear ${name}!
<br>
Add a player to database:
<br>
<form method="post">
    Name: <input name="name" type="text"/> <br>
    Surname: <input name="surname" type="text"/> <br>
    Club: <input name="club" type="text"/> <br>
    <input type="submit"/>
</form>
</body>
</html>