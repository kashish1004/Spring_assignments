<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body style = 'text-align: center;background-color: cyan'>
	<h2 style ="color:red;"> ${chaU } </h2>
	<form action = "signup" method = "post">
		<p>Username:<input type = "text" name = "username" required></p>
		<p>Password:<input type = "password" name = "password" required></p>
		<input type = "submit" value = "Sign Up">
	</form>
</body>
</html>